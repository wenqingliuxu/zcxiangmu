package com.demo.zcxm.user.service.bo;

/**
 * @AuthorName 刘旭
 * @DATE2019/9/2919:29
 */
public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userNc;
    private String userEmail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserNc() {
        return userNc;
    }

    public void setUserNc(String userNc) {
        this.userNc = userNc;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userNc='" + userNc + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
