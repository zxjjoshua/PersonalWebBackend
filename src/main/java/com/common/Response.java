package com.common;

import com.Dao.User.User;

public class Response {
    private UserInfo userInfo;
    private Object payload;
    private WebError error;

    public Response(){}

    public void setError(WebError error) {
        this.error = error;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Object getPayload() {
        return payload;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public WebError getError() {
        return error;
    }

}
