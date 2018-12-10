package com.warrous.contactpointlatest.signup.response;

public class SignUpResponse {

    int  success;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "SignUpResponse{" +
                "success='" + success + '\'' +
                '}';
    }
}
