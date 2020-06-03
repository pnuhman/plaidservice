package com.buckzy.plaid.model;

public abstract class BaseResponse {
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "requestId='" + requestId + '\'' +
                '}';
    }
}