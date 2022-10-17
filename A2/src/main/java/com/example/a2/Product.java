package com.example.a2;

public abstract class Product {
    protected int code;
    protected String name;
    protected double cost;

    public Product(int code, String name, double cost) {
        this.code = code;
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
