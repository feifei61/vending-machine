package com.example.a2;

public class User{
    private Role role; //role is set as owner by the system or set as something else by owner -> modify call.
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setRole(Role role){
        this.role = role;
    }

    // ---------------------------
    // -------- Purchase ---------
    // ---------------------------
    
    // Select by product code
    public void selectItem(int code) {
        
    }

    public void selectItemQty() {

    }
}