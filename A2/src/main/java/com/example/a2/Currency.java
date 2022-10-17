package com.example.a2;

public class Currency {
    // Available coins: 0.05, 0.1, 0.2, 0.5, 1, 2 
    // Available notes: 5 , 10, 20, 50, 100
    private double amount;
    private int qty;

    public Currency(double amount, int qty) {
        this.amount = amount;
        this.qty = qty;
    }
}
