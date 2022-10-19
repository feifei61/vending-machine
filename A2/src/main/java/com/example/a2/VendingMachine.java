package com.example.a2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.a2.products.Product;

public class VendingMachine {
    private List<Product> productInventory;
    private List<Currency> currencyInventory;
    private HashMap<Integer,Integer> cart = new HashMap<>(); // Map<prodID,qty>
    private final String[] categories = {"Drinks", "Chocolates", "Chips", "Candies"}; // pre-defined; can't be modified
    private DBManage database;

    public VendingMachine(DBManage database) {
        this.database = database;
        updateProductInventory();
    }

    public void updateProductInventory() {
        this.productInventory = database.getProducts();
    }

    public Product findProductByID(int prodID) {
        for (Product product : this.productInventory) {
            if (product.getCode() == prodID)
                return product;
        }
        return null;
    }

    public List<Product> ShowProductCategorized(String category) {
        List<Product> resultSet = new ArrayList<Product>();
        for (Product product : this.productInventory) {
            if (product.getCategoryStr().equals(category)) {
                resultSet.add(product);
            }
        }
        return resultSet;
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

    public String[] getCategories() {
        return this.categories;
    }

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
