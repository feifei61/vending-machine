package com.example.a2;

public class System{

    private VendingMachine vendingMachineSession;

    public System() {
        this.vendingMachineSession = new VendingMachine();
    }

    /*
        Method trys to add a new user to the database. Returns true if successful, false otherwise.
     */
    public boolean addUser(User user){
        return false;
    }

    // TODO: test only
    public VendingMachine getVendingMachine() {
        return this.vendingMachineSession;
    }

}