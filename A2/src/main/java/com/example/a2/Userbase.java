package com.example.a2;
import java.util.ArrayList;

public class Userbase{
    private ArrayList<User> users = new ArrayList<User>();
    private User owner;

    public Userbase(String username, String password){
        owner = new User(username, password);
        owner.setRole(new Owner());
    }
}