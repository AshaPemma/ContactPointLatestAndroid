package com.warrous.contactpointlatest.network;


public class APIError {
    private int code;
    private String message;
    private String method;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "APIError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
