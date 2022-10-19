package com.example.a2.products;

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

    public abstract String getCategoryStr();

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getQty() {
        return this.qty;
    }
    
}
