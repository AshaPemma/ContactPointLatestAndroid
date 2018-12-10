package com.warrous.contactpointlatest.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


import com.warrous.contactpointlatest.ContactPointApp;
import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.framework.AndroidUtil;

import butterknife.ButterKnife;



public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View {
    TextView tv_toolbar_title;
    Toolbar toolbar;
    private ProgressDialog progressDialog;

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Activity getAppActivity() {
        return this;
    }

    @Override
    public void showLoader() {
        AndroidUtil.hideKeyBoard(this);
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this, R.style.ProgressBarSmall);
            progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);

        }
        progressDialog.show();
    }

    @Override
    public void dismissLoader() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showError(String message) {
        AndroidUtil.showSnackBarSafe(this, message);
    }

    @Override
    public ContactPointApp getAvailApp() {
        return (ContactPointApp) getApplication();
    }

    protected void injectButterKnife(Activity activity) {
        ButterKnife.bind(activity);
    }

    protected void setToolBarTitle(int stringId) {
        tv_toolbar_title = findViewById(R.id.tv_header);
        tv_toolbar_title.setText(getResources().getString(stringId));

//        toolbar = findViewById(R.id.toolbar);
//
//        toolbar.setTitle(stringId);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
    }

    protected void setToolBarBackClick() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidUtil.hideKeyBoard(getAppActivity());
                finish();
            }
        });
    }

    protected void setRobotoMedium(int resId){
        TextView textView =  findViewById(resId);
        setRobotoMedium(textView);
    }

    protected void setRobotoRegular(int resId){
        TextView textView =  findViewById(resId);
        setRobotoRegular(textView);
    }

    protected void setRobotoMedium(TextView textView){
       // FontsUtil.getInstance(this).setMediumFont(textView);
    }

    protected void setRobotoRegular(TextView textView){
        //FontsUtil.getInstance(this).setRegularFont(textView);
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        AndroidUtil.hideKeyBoard(this);
        super.onBackPressed();
    }

    public void setToolBar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }
}
