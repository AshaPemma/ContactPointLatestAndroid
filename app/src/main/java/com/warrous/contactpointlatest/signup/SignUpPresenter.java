package com.warrous.contactpointlatest.signup;

import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.Util.ValidationUtil;
import com.warrous.contactpointlatest.base.BasePresenter;
import com.warrous.contactpointlatest.signup.request.SignUpRequest;

import java.util.Map;

public class SignUpPresenter  extends BasePresenter implements SignUpContract.Presenter{

    SignUpContract.View view;


    public SignUpPresenter(SignUpContract.View view) {
        super(view);
        this.view = view;
    }

    @Override
    public void onSaveClick(SignUpRequest inputs) {
//        if (ValidationUtil.isEmpty(inputs.getName()) || ValidationUtil.isEmpty(inputs.getOrgName()) || ValidationUtil.isEmpty(inputs.getUserName())
//                || ValidationUtil.isEmpty(inputs.getPassword()) ) {
////            if (ValidationUtil.isEmpty(inputs.getFirstName())) {
////                view.onFnameError(getString(R.string.on_fname_error));
////            }
////            if (ValidationUtil.isEmpty(inputs.getLastName())) {
////                view.onLnameError(getString(R.string.on_lname_error));
////            }
////            if (ValidationUtil.isEmpty(inputs.getMobileNo())) {
////                view.onMobileError(getString(R.string.on_mobile_error));
////            }
////            if (ValidationUtil.isEmpty(inputs.getEmail())) {
////                view.onEmailError(getString(R.string.on_email_only));
////            }
////            if (ValidationUtil.isEmpty(inputs.getPassword())) {
////                view.onPasswordError(getString(R.string.on_password_error));
////            }
//            return;
//        }
//        if (!ValidationUtil.isEmpty(inputs.getUserName())) {
//
//            if (!ValidationUtil.isValidEmail(inputs.getUserName())) {
//               // view.onEmailError(getString(R.string.on_email_only));
//                return;
//
//            }
//            //}
//        }
//
//
//
//
//
//        if (!ValidationUtil.isValidPassword(inputs.getPassword())) {
//            //view.onPasswordError(getString(R.string.on_valid_password_error));
//            return;
//        }


        view.showLoader();
        execute(getApiInterface().signUp(inputs.getName(),inputs.getUserName(),inputs.getPassword(),inputs.getOrgName()));
    }

    @Override
    public void registerDevice(String token) {

    }

    @Override
    public void onResponse(String method, Object result) {
        super.onResponse(method, result);

        view.onSaveSuccess();

        }

}
