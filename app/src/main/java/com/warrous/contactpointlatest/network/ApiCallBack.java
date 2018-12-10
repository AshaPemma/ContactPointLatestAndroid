package com.warrous.contactpointlatest.network;



public interface ApiCallBack<T> {

    void onResponse(String method, Object result);
    void onError(APIError error);
}


