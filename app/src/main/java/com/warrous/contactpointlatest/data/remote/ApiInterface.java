package com.warrous.contactpointlatest.data.remote;



import com.warrous.contactpointlatest.login.GmailRequest;
import com.warrous.contactpointlatest.login.LoginResponse;
import com.warrous.contactpointlatest.network.ApiResponse;
import com.warrous.contactpointlatest.signup.request.SignUpRequest;
import com.warrous.contactpointlatest.signup.response.SignUpResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface ApiInterface {


//    @POST(ApiEndPoint.REGISTER_API)
//    Call<ApiResponse<SignUpResponse>> signUp(@Body SignUpRequest signUpRequest);


    @FormUrlEncoded
    @POST(ApiEndPoint.REGISTER_API)
    Call<ApiResponse<SignUpResponse>> signUp(@Field("name") String title,
                                             @Field("userName") String body,
                                             @Field("password") String userId,@Field("orgName") String orgName);

    @POST(ApiEndPoint.REGISTER_WITH_GMAIL)
    Call<ApiResponse<LoginResponse>> registerWithGmail(@Body GmailRequest signInRequest);


}
