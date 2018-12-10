package com.warrous.contactpointlatest.network;


import java.util.List;

public class ApiResponse<T> {
    boolean error;
    List result;
    APIError apiError;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public APIError getApiError() {
        return apiError;
    }

    public void setApiError(APIError apiError) {
        this.apiError = apiError;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "error=" + error +
                ", result=" + result +
                ", apiError=" + apiError +
                '}';
    }
}
