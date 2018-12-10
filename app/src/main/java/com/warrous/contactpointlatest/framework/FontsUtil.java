package com.warrous.contactpointlatest.framework;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by asha on 18/1/18.
 */

public class FontsUtil {

    Context context;
    static FontsUtil fontsUtil;
    Typeface robotRegular;
    Typeface robotMedium;

    public enum FontFamily {
        ROBOTO_REG,
        ROBOTO_MED;
    }

    private FontsUtil(Context context) {
        robotRegular  = Typeface.createFromAsset(context.getAssets(), "font/Roboto-Regular.ttf");
        robotMedium  = Typeface.createFromAsset(context.getAssets(), "font/Roboto-Medium.ttf");

    }

    public static FontsUtil getInstance(Context context){
        if(fontsUtil == null){
            fontsUtil = new FontsUtil(context);
        }

        return fontsUtil;
    }

    public void setFont( FontFamily fontFamily,TextView... textViews){
        switch (fontFamily){
            case ROBOTO_MED:
                setMediumFont(textViews);
                break;
            case ROBOTO_REG:
                setRegularFont(textViews);
                break;
        }

    }
    public void setRegularFont(TextView... textViews){
        for(TextView view : textViews){
            view.setTypeface(robotRegular);
        }
    }

    public void setMediumFont(TextView... textViews){
        for(TextView view : textViews){
            view.setTypeface(robotMedium);
        }
    }
}
