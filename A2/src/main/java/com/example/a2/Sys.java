package com.example.a2;

public class Sys{

    private VendingMachine vendingMachine;
    private DBManage database;

    public Sys() {
        this.database = new DBManage("database.sqlite");
        database.createDB();
        this.vendingMachine = new VendingMachine(database);
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

    public DBManage getDatabase(){
        return database;
    }

}