package com.warrous.contactpointlatest.framework;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;


public class TextInputLayoutWrapper extends TextInputLayout implements TextWatcher {
    public TextInputLayoutWrapper(Context context) {
        super(context);
    }

    public TextInputLayoutWrapper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextInputLayoutWrapper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
    }

    public void setText(@StringRes int id) {
        setText(getResources().getString(id));
    }

    public void setText(String text) {
        getEditText().setText(text);

    }

    public String getText(){
        return getEditText().getText().toString();
    }

    public void init() {
        getEditText().addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        setErrorEnabled(false);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void setCustomFont(FontsUtil.FontFamily fontFamily){
        FontsUtil.getInstance(getContext()).setFont(fontFamily,getEditText());
    }
}
