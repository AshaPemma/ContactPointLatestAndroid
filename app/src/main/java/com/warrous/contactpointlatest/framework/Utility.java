package com.warrous.contactpointlatest.framework;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;


import com.warrous.contactpointlatest.dashboard.models.DashBoardTopBarPannel;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gokul Kalagara on 1/25/2018.
 */

public class Utility {
    public static List<DashBoardTopBarPannel> getTopBarPanelElements(int value)
    {
        List<DashBoardTopBarPannel> list = new ArrayList<>();
        switch (value)
        {

            case 0:
                // delivery vehicle
                list.add(new DashBoardTopBarPannel("Sent Emails","",true));
                list.add(new DashBoardTopBarPannel("Scheduled Emails","",false));
                list.add(new DashBoardTopBarPannel("Draft Emails","",false));
                break;

            case 1:
                // delivery vehicle
                list.add(new DashBoardTopBarPannel("Segment Lists","",true));
                list.add(new DashBoardTopBarPannel("Active Consumers","",false));
                list.add(new DashBoardTopBarPannel("Navigation","",false));
                break;
        }

        return list;
    }
}