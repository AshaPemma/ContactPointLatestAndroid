package com.warrous.contactpointlatest.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;


import com.warrous.contactpointlatest.ContactPointApp;
import com.warrous.contactpointlatest.data.remote.ApiInterface;
import com.warrous.contactpointlatest.network.RestClient;


public interface BaseContract {

    interface View {
        Context getContext();

        Activity getAppActivity();

        ContactPointApp getAvailApp();

        void showLoader();

        void dismissLoader();

        void showError(String message);
    }

    interface Presenter {
        Resources getResource();

        String getString(int resId);

        // Life cycle methods.
        void onStart();

        void onResume();

        void onPause();

        void onDestroy();

        RestClient getRestClient();

        ApiInterface getApiInterface();
    }
}
