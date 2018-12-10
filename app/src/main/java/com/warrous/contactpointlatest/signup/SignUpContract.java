package com.warrous.contactpointlatest.signup;

import com.warrous.contactpointlatest.base.BaseContract;
import com.warrous.contactpointlatest.signup.request.SignUpRequest;

public interface SignUpContract {

    interface View extends BaseContract.View {

        void onMobileError(String error);
        void onEmailError(String error);
        void onPasswordError(String error);
        void onFnameError(String error);
        void onLnameError(String error);
        void onAllFieldsError();
        void onSaveSuccess();
    }

    interface Presenter extends BaseContract.Presenter {

        void onSaveClick(SignUpRequest inputs);

        void registerDevice(String token);


    }
}
