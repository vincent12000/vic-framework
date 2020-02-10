package com.vicframework.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class RestResponse<T> {

    private boolean success;

    private String errorCode;

    private String errorMsg;

    private T data;

    public RestResponse(T data) {
        this.data = data;
    }

    public RestResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public RestResponse(boolean success, String errorCode, String errorMsg) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static <T> RestResponse<T> success(T data) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        restResponse.setData(data);
        return restResponse;
    }

    public static RestResponse failed(String errorCode, String errorMsg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(false);
        restResponse.setErrorCode(errorCode);
        restResponse.setErrorMsg(errorMsg);
        return restResponse;
    }



}
