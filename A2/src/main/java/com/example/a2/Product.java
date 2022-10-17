package com.example.a2;

public abstract class Product {
    protected int code;
    protected String name;
    protected double cost;

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
