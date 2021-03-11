package com.common;

import com.Dao.User.User;

public class UserInfo {
    private User user;
    private boolean isLogin;
    private String accessToken;
    private String refreshToken;

    public void setUser(User user) {
        this.user = user;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public User getUser() {
        return user;
    }

    public boolean getIsLogin(){
        return isLogin;
    }
}
