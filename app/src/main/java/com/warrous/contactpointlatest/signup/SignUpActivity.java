package com.warrous.contactpointlatest.signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.base.BaseActivity;
import com.warrous.contactpointlatest.dashboard.DashBoardActivity;
import com.warrous.contactpointlatest.framework.ActivityUtils;
import com.warrous.contactpointlatest.login.LoginActivity;
import com.warrous.contactpointlatest.signup.request.SignUpRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements SignUpContract.View{
    SignUpContract.Presenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        injectButterKnife(this);
        presenter = new SignUpPresenter(this);
    }
    @OnClick(R.id.tv_start_now)
    public void startNow(){
        saveData();
        //ActivityUtils.startActivity(SignUpActivity.this,DashBoardActivity.class,null);
    }
    @OnClick(R.id.tv_login)
    public void login(){
        ActivityUtils.startActivity(SignUpActivity.this,LoginActivity.class,null);
    }

    @Override
    public void onMobileError(String error) {

    }

    @Override
    public void onEmailError(String error) {

    }

    @Override
    public void onPasswordError(String error) {

    }

    @Override
    public void onFnameError(String error) {

    }

    @Override
    public void onLnameError(String error) {

    }

    @Override
    public void onAllFieldsError() {

    }

    @Override
    public void onSaveSuccess() {
        Toast.makeText(this,"Sucessfully Registerd",Toast.LENGTH_LONG).show();
    }

    public void saveData() {

        SignUpRequest inputs = new SignUpRequest();

        inputs.setName("ASHA");
        inputs.setUserName("ashuasha5gmail.com");
        inputs.setPassword("ashupandu55*A");
        inputs.setOrgName("Generic");

        presenter.onSaveClick(inputs);
    }

}
