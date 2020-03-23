package com.example.fragmentinsidefragmentpractice.model;

public class UserPojo {
    public String userName;
    public String userPhone;
    public String userInvitationCode;

    public UserPojo(String userName, String userPhone) {
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public UserPojo(String userName, String userPhone, String userInvitationCode) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userInvitationCode = userInvitationCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserInvitationCode() {
        return userInvitationCode;
    }

    public void setUserInvitationCode(String userInvitationCode) {
        this.userInvitationCode = userInvitationCode;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userInvitationCode='" + userInvitationCode + '\'' +
                '}';
    }
}
