package com.warrous.contactpointlatest.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.warrous.contactpointlatest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddNewImageActivity extends AppCompatActivity {

    @BindView(R.id.sp_image_type)
    Spinner spImageType;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
        ButterKnife.bind(this);
bindData();
    }
    public void bindData(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.image_types));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spImageType.setAdapter(arrayAdapter);
        spImageType.setSelection(0);
    }
    @OnClick(R.id.iv_back)
    public void onClickBack(){
        finish();
    }
    @OnClick(R.id.iv_check)
    public void onClickCheck(){
        finish();
    }
}
