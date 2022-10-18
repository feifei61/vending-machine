package com.example.a2.items;

public class Chips implements Product{
    private final int limit = 15;
    private int quantity;
    private double cost;
    private ChipsType type;

    public Chips(ChipsType type, int startQuantity) {
        this.type = type;
        this.quantity = startQuantity;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        switch (type) {
            case KETTLE:
                return "Kettle";
            case PRINGLES:
                return "Pringles";
            case SMITHS:
                return "Smiths";
            case THINS:
                return "Thins";
            default:
                return "default";
        }
    }
    
    
}