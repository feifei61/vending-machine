package com.example.a2;

public class Sys{

    private VendingMachine vendingMachine;

    public Sys() {
        this.vendingMachine = new VendingMachine();
    }

    /*
        Method trys to add a new user to the database. Returns true if successful, false otherwise.
     */
    public boolean addUser(User user){
        return false;
    }

    public VendingMachine getVendingMachine() {
        return this.vendingMachine;
    }

}