package com.example.a2;

import java.util.HashMap;
import java.util.List;

import com.example.a2.products.Product;

public class VendingMachine {
    private List<Product> productInventory;
    private List<Currency> currencyInventory;
    private HashMap<Integer,Integer> cart = new HashMap<>(); // Map<prodID,qty>

    public VendingMachine() {
        updateProductInventory();
    }

    public void updateProductInventory() {
        this.productInventory = DBManage.getProducts();
    }

    public Product findProductByID(int prodID) {
        for (Product product : this.productInventory) {
            if (product.getCode() == prodID)
                return product;
        }
        return null;
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

    public HashMap<Integer,Integer> getCart() {
        return this.cart;
    }
}
