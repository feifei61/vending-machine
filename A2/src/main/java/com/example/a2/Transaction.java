package com.example.a2;

import java.util.Date;

public class Transaction {

    private final int transID;
    private int customerID;
    private final int prodID;
    private final int quantity;
    private final boolean success;
    private final Date date;

    public Transaction(int transID, int prodID, int quantity, boolean success, Date date, int customerID){
        this.transID = transID;
        this.customerID = customerID;
        this.prodID = prodID;
        this.date = date;
        this.success = success;
        this.quantity = quantity;
    }

    public Transaction(int transID, int prodID, int quantity, boolean success, Date date){
        this.transID = transID;
        this.prodID = prodID;
        this.date = date;
        this.success = success;
        this.quantity = quantity;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getProdID() {
        return prodID;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSuccess() {
        return success;
    }

    public Date getDate() {
        return date;
    }

    public int getTransID() {
        return transID;
    }
}
