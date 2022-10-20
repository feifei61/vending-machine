package com.example.a2.items;

public class Chocolate implements Product{
    private final int limit = 15;
    private int quantity;
    private double cost;
    private ChocoType type;

    public Chocolate(ChocoType type, int startQuantity) {
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
            case BOUNTY:
                return "Bounty";
            case MARS:
                return "Mars";
            case MM:
                return "M&M";
            case SNICKERS:
                return "Snickers";
            default:
                return "default";
            
        }
    }
    
}