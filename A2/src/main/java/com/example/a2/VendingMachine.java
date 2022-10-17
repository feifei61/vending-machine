package com.example.a2;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {
    private List<Product> productInventory;
    private List<Currency> currencyInventory;
    private HashMap<Integer,Integer> cart; // Map<prodID,qty>

    public VendingMachine() {
        updateProductInventory();
    }

    public void updateProductInventory() {
        this.productInventory = DBManage.getProducts();
    }

    // ---------------------------
    // -------- Cart -------------
    // ---------------------------
    
    // Button(prodID) + input qty -> addToCart
    public void addToCart(int prodID, int qty) {
        this.cart.put(prodID, qty);
    }

    // ---------------------------
    // ----- SETTER/GETTER -------
    // ---------------------------

    public List<Product> getProductInventroy() {
        return this.productInventory;
    }

    public List<Currency> getCurrencyInventory() {
        return this.currencyInventory;
    }
}
