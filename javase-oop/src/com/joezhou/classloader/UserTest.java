package com.joezhou.classloader;

public class UserTest{
    public static void main(String[] args){
        User user = new User();
        user.methodA();
    }
}

class User{
    private String name;
    void methodA(){
        methodB();
    }
    void methodB(){
        System.out.println("b");
    }
}