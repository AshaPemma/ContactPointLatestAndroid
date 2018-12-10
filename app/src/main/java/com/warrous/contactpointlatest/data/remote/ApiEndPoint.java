package com.warrous.contactpointlatest.data.remote;



public interface ApiEndPoint {


   // https://api.warrous.com:19081/warrous.ms.auth/warrous.ms.auth.api/connect/token
    String AUTH="warrous.ms.auth/";
    String AUTH_API="warrous.ms.auth.api/api/";



    String REGISTER_API=AUTH+AUTH_API+"Mobile/RegisterUser";

    String REGISTER_WITH_GMAIL=AUTH+AUTH_API+"User/RegisterUser";

}
