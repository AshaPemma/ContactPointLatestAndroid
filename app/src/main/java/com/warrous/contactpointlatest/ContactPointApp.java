package com.warrous.contactpointlatest;

import android.app.Application;


import com.facebook.drawee.backends.pipeline.Fresco;

import com.google.firebase.FirebaseApp;
import com.warrous.contactpointlatest.data.remote.ApiInterface;
import com.warrous.contactpointlatest.network.RestClient;



public class ContactPointApp extends Application {

    RestClient restClient;
    ApiInterface apiInterface;

    boolean hasTakeTour;

    @Override
    public void onCreate() {
        super.onCreate();
       //Fabric.with(this, new Crashlytics());
        Fresco.initialize(this);
      //  FacebookSdk.sdkInitialize(getApplicationContext());
        FirebaseApp.initializeApp(this);
//        String fcmToken = FirebaseInstanceId.getInstance().getToken();
//        LMLog.getInstance().error(MyFirebaseMessagingService.TAG,fcmToken);
        initializeRetrofit();


    }

    private void initializeRetrofit() {
      // Aws
        //RestClient.Builder builder = new RestClient.Builder(this, "http://ec2-13-127-142-169.ap-south-1.compute.amazonaws.com:3100/");
                RestClient.Builder builder = new RestClient.Builder(this, "https://api.warrous.com:19081/");

//        RestClient.Builder builder = new RestClient.Builder(this, "http://192.168.0.150:3100/");
//        RestClient.Builder builder = new RestClient.Builder(this, "http://cardstel.co.in:3100/");
        apiInterface = builder.create(ApiInterface.class);
        restClient = builder.build();
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public void setHasTakeTour(boolean hasTakeTour) {
        this.hasTakeTour = hasTakeTour;
    }
}
