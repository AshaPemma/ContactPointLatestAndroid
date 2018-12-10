package com.warrous.contactpointlatest.login;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;
import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.base.BaseActivity;
import com.warrous.contactpointlatest.dashboard.DashBoardActivity;
import com.warrous.contactpointlatest.framework.ActivityUtils;
import com.warrous.contactpointlatest.framework.ContactPointLog;
import com.warrous.contactpointlatest.signup.SignUpActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 234;
    LoginContract.Presenter presenter;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        injectButterKnife(this);
        presenter=new LoginPresenter(this);
        mAuth = FirebaseAuth.getInstance();


generateHashkey();
        LISessionManager.getInstance(getApplicationContext()).init(this, buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.
            }
            @Override
            public void onAuthError(LIAuthError error) {
                // Handle authentication errors
            }
        }, true);
        //Then we need a GoogleSignInOptions object
        //And we need to build it as below
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //Then we will get the GoogleSignInClient object from GoogleSignIn class
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }
    @OnClick(R.id.tv_create_account)
    public void onClickCreateAccount(){
        ActivityUtils.startActivity(LoginActivity.this,SignUpActivity.class,null);
    }
    @OnClick(R.id.btn_login)
    public void onClickLogin(){
        ActivityUtils.startActivity(LoginActivity.this,DashBoardActivity.class,null);
    }
    @OnClick(R.id.btn_google)
    public void onCLickGoogleLogin(){
        signInWithGoogle();
    }

    // Build the list of member permissions our LinkedIn session requires
    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE);
    }
    public void generateHashkey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.warrous.contactpointlatest",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());

                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("Has", e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            Log.d("Has", e.getMessage(), e);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {

            mAuth.signOut();
        }
    }
    private void signInWithGoogle() {
        //getting the google signin intent
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();

        //starting the activity for result
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ContactPointLog.getInstance().info(requestCode + data.toString());
        if (requestCode == RC_SIGN_IN) {

            //Getting the GoogleSignIn Task
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                //Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
               presenter.registerGoogleUser(account);
                //authenticating with firebase
//                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                e.printStackTrace();
                ContactPointLog.getInstance().debug("AUTH", e.getStatusCode() + "" + e.getLocalizedMessage());
                //Toast.makeText(GetStartedActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
           // callbackManager.onActivityResult(requestCode, resultCode, data);
//            faceBookLoginMngr.onActivityResult(requestCode, resultCode, data);
            LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
        }
    }

    @Override
    public void onGoogleSignInSucess() {

    }

    @Override
    public void onFacebookSignInSucess() {

    }


}
