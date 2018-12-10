package com.warrous.contactpointlatest.login;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.warrous.contactpointlatest.base.BaseContract;

public interface LoginContract {

    interface View extends BaseContract.View {

        void onGoogleSignInSucess();

        void onFacebookSignInSucess();

    }

    interface Presenter extends BaseContract.Presenter {

        void registerGoogleUser(GoogleSignInAccount googleUser);

        void registerFacebookUserWitAvail(String fbToken);

      //  void registerDevice(String token);


    }
}
