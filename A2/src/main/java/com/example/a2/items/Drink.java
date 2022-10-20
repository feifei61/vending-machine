package com.example.a2.items;

public class Drink implements Product{
    private final int limit = 15;
    private int quantity;
    private double cost;
    private DrinkType type;

    public Drink(DrinkType type, int quantity) {
        this.quantity = quantity;
        this.type = type;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        switch (type) {
            case COLA:
                return "Cola";
            case JUICE:
                return "Juice";
            case PEPSI:
                return "Pepsi";
            case SPRITE:
                return "Sprite";
            case WATER:
                return "Water";
            default:
                return "default";
        }
    }
}