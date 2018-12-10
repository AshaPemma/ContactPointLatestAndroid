package com.warrous.contactpointlatest.consumers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.warrous.contactpointlatest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddContactActivity extends AppCompatActivity {
    @BindView(R.id.spinner_email)
    Spinner spEmail;
    @BindView(R.id.spinner_phone)
    Spinner spPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        ButterKnife.bind(this);
        intialize();
    }
    public void intialize(){
       setEmailSpinner();
       setPhoneSpinner();

    }
    public void setEmailSpinner(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.email_items));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEmail.setAdapter(arrayAdapter);
        spEmail.setSelection(0);
    }
    public void setPhoneSpinner(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.mobile_items));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPhone.setAdapter(arrayAdapter);
        spPhone.setSelection(0);
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
