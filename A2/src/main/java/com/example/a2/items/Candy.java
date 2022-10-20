package com.example.a2.items;

public class Candy implements Product{
    private final int limit = 15;
    private int quantity;
    private double cost;
    private CandyType type;

    public Candy(CandyType type, int startQuantity) {
        this.type = type;
        this.quantity = quantity;
    }

    @Override
    public double getCost() {
        // TODO Auto-generated method stub
        return cost;
    }

    @Override
    public String getName() {
        switch (type) {
            case MENTOS:
                return "Mentos";
            case SKITTLES:
                return "Skittles";
            case SOURPATCH:
                return "Sour Patch";
            default:
                return "default";
        }
    }
}