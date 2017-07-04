package com.example.sharadsingh.ralmdatabadeofmap;

/**
 * Created by truxapp_mac on 2/16/17.
 */

public class BaseResponse {
    private String errorCode;
    private String errorMesaage;
    private String count;



    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getErrorMesaage() {
        return errorMesaage;
    }

    public void setErrorMesaage(String errorMesaage) {
        this.errorMesaage = errorMesaage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
