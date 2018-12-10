package com.warrous.contactpointlatest.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.dashboard.adapter.TemplatesAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewEmailActivity extends AppCompatActivity {

    @BindView(R.id.rv_templates)
    RecyclerView rvTemplates;
    @BindView(R.id.email_type_spinner)
    Spinner emailTypeSpinner;

    @BindView(R.id.from_email_spinner)
    Spinner fromEmailSpinner;

    TemplatesAdapter templatesAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_email);
        ButterKnife.bind(this);
        Fresco.initialize(this);
        intialize();
    }
    public void intialize(){
        rvTemplates.setLayoutManager(
                new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));

        templatesAdapter = new TemplatesAdapter(this,null);
        rvTemplates.setAdapter(templatesAdapter);
        setEmailTypeSpinner();
        setFromEmailSpinner();
    }
    public void setEmailTypeSpinner(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.email_types));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emailTypeSpinner.setAdapter(arrayAdapter);
        emailTypeSpinner.setSelection(0);
    }

    public void setFromEmailSpinner(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.test_emails));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromEmailSpinner.setAdapter(arrayAdapter);
        fromEmailSpinner.setSelection(0);
    }

    @OnClick(R.id.iv_back)
    public void onClickBack(){
        finish();
    }
}
