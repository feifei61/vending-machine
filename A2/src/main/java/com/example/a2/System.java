package com.example.a2;

import java.util.ArrayList;

import com.example.a2.items.Candy;
import com.example.a2.items.CandyType;
import com.example.a2.items.Chips;
import com.example.a2.items.ChipsType;
import com.example.a2.items.ChocoType;
import com.example.a2.items.Chocolate;
import com.example.a2.items.Drink;
import com.example.a2.items.Product;
import com.example.a2.items.DrinkType;

public class System{
    private final int startQuantity = 7;
    private ArrayList<Product> products;

    public System() {
        products = new ArrayList<>();
        initProducts();
    }

    /* 
     * initiates products
     */
    private void initProducts() {
        products.add(new Drink(DrinkType.WATER, startQuantity));
        products.add(new Drink(DrinkType.SPRITE, startQuantity));
        products.add(new Drink(DrinkType.COLA, startQuantity));
        products.add(new Drink(DrinkType.PEPSI, startQuantity));
        products.add(new Drink(DrinkType.JUICE, startQuantity));

        products.add(new Chocolate(ChocoType.MARS, startQuantity));
        products.add(new Chocolate(ChocoType.MM, startQuantity));
        products.add(new Chocolate(ChocoType.BOUNTY, startQuantity));
        products.add(new Chocolate(ChocoType.SNICKERS, startQuantity));

        products.add(new Chips(ChipsType.PRINGLES, startQuantity));
        products.add(new Chips(ChipsType.SMITHS, startQuantity));
        products.add(new Chips(ChipsType.KETTLE, startQuantity));
        products.add(new Chips(ChipsType.THINS, startQuantity));

        products.add(new Candy(CandyType.MENTOS, startQuantity));
        products.add(new Candy(CandyType.SOURPATCH, startQuantity));
        products.add(new Candy(CandyType.SKITTLES, startQuantity));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    /*
        Method trys to add a new user to the database. Returns true if successful, false otherwise.
     */
    public boolean addUser(User user){
        return false;
    }
}