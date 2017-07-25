package com.tiffany.phippy.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by toby on 15/05/2017.
 */

public class BaseModel<T> {

    @SerializedName("statusCode")
    private int statusCode;

    @SerializedName("message")
    private String msg;

    @SerializedName("data")
    private T data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "statusCode=" + statusCode +
                ", message='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
