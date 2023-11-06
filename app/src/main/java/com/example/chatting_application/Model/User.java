package com.example.chatting_application.Model;

public class User {
    String userName, profilePic, userId, lastMgs, mail, password;

    public User(String userName, String profilePic, String userId, String lastMgs, String mail, String password) {
        this.userName = userName;
        this.profilePic = profilePic;
        this.userId = userId;
        this.lastMgs = lastMgs;
        this.mail = mail;
        this.password = password;
    }

    public User(){}

    //SingUp constructor
    public User(String userName, String mail, String password) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
    }




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMgs() {
        return lastMgs;
    }

    public void setLastMgs(String lastMgs) {
        this.lastMgs = lastMgs;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
