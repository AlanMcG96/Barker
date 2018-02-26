package com.example.alan.barker;

/**
 * Created by Alan on 05/02/2018.
 */

public class User {

    public String email;
    public String password;
    public String userID;




    //required default constructor
    public User() {
    }

    public User(String email, String password, String userID) {
        this.email = email;
        this.password = password;
        this.userID = userID;


    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID(){
        return userID;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

}