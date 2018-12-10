package com.warrous.contactpointlatest.network;

import android.content.Context;


import com.warrous.contactpointlatest.data.remote.ApiEndPoint;
import com.warrous.contactpointlatest.framework.ContactPointLog;
import com.warrous.contactpointlatest.framework.PreferenceManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


class TokenInterceptor implements Interceptor {
    private static final String AUTHORIZATION = "Authorization";
    private final Context context;


    public TokenInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        ContactPointLog.getInstance().info("Request method : " + original.url().toString());
        String url = original.url().toString();
        String authToken;
        //|| url.contains(ApiEndPoint.SIGNUP)
        if (url.contains(ApiEndPoint.REGISTER_API)) {
            return chain.proceed(original);
        } else {
            authToken = PreferenceManager.getStringValue(context, PreferenceManager.KEY_TOKEN);

        }
        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .header(AUTHORIZATION, authToken)
                .method(original.method(), original.body());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}