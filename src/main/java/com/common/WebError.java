package com.common;

import java.util.HashMap;

public class WebError {
    private String errCode;
    private String errMsg;

    public static enum errCodeList{
        // SQL err
        ExistedEmail, ExistedUsername;

        public static HashMap<String, String > MsgList={}

    }

    public WebError(){}

    public WebError(String errCode, String errMsg){
        this.errCode=errCode;
        this.errMsg=errMsg;
    }

    public WebError(errCodeList errCode, String errMsg){
        this.errCode=errCode;
        this.errMsg=errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "WebError{" +
                "errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
