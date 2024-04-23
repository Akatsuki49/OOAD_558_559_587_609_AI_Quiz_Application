package com.example.demo.models;

public class AuthReply {
    private String s;

    public AuthReply(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
    	System.out.println("/////"+s);
        return "Reply{" +
                "s='" + s + '\'' +
                '}';
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
