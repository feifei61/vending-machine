package com.example.a2;

public abstract class Product {
    protected int code;
    protected String name;
    protected double cost;
    protected int qty;

    public Product(int code, String name, double cost, int qty) {
        this.code = code;
        this.name = name;
        this.cost = cost;
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
