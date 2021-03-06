package com.warrous.contactpointlatest.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.warrous.contactpointlatest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FullImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.iv_cross)
    public void onClickCross(){
        finish();
    }
}
