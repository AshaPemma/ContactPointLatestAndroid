package com.warrous.contactpointlatest.accountpreferences.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.accountpreferences.AccountPreferencesActivity;
import com.warrous.contactpointlatest.framework.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.iv_back)
    public void onClickBack(){
        ActivityUtils.startActivity(ProfileActivity.this,AccountPreferencesActivity.class,null);
    }
}
