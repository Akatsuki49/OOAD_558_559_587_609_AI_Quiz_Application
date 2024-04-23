package com.example.demo.models;

public class Authentication {
    private String userName;
    private String password;
    private boolean isSignUp;
//    private String signUpBox;

//    public String isSignUpBox() {
//        return signUpBox;
//    }
//
//    public void setSignUpBox(String signUpBox) {
//        this.signUpBox = signUpBox;
//    }
    
    public boolean getIsSignUp() {
    	return isSignUp;
    }
    
    public void setIsSignUp(boolean isSignUp) {
        this.isSignUp = isSignUp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
