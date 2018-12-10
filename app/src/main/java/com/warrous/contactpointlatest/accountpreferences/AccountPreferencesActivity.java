package com.warrous.contactpointlatest.accountpreferences;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;

import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.accountpreferences.profile.ProfileActivity;
import com.warrous.contactpointlatest.framework.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountPreferencesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_preferences);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.iv_edit)
    public void ivEdit(){
        ActivityUtils.startActivity(AccountPreferencesActivity.this,ProfileActivity.class,null);
    }
}
