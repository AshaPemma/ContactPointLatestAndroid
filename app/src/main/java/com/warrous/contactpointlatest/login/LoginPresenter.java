package com.warrous.contactpointlatest.login;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.warrous.contactpointlatest.base.BasePresenter;

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    LoginContract.View view;


    public LoginPresenter(LoginContract.View view) {
        super(view);
        this.view = view;
    }

    @Override
    public void registerGoogleUser(GoogleSignInAccount googleUser) {
        GmailRequest registerRequest = new GmailRequest();
        registerRequest.setToken(googleUser.getIdToken());
        execute(getApiInterface().registerWithGmail(registerRequest));
    }

    @Override
    public void registerFacebookUserWitAvail(String fbToken) {

    }
}
