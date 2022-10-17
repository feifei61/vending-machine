package com.example.a2;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {
    private List<Product> productInventory;
    // Available coins: 0.05, 0.1, 0.2, 0.5, 1, 2 
    // Available notes: 5 , 10, 20, 50, 100
    private HashMap<Double,Integer> currencyInventory; //Map<Currency,Qty>

    public VendingMachine() {
        updateProductInventory();
    }

    public void updateProductInventory() {
        this.productInventory = DBManage.getProducts();
    }

    public List<Product> getProductInventroy() {
        return this.productInventory;
    }

    public HashMap<Double,Integer> getCurrencyInventory() {
        return this.currencyInventory;
    }
}
