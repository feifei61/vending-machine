package com.example.a2;

import java.util.List;

public class VendingMachine {
    private List<Product> productInventory;
    private List<Currency> currencyInventory;

    public VendingMachine() {
        updateProductInventory();
    }

    public void updateProductInventory() {
        this.productInventory = DBManage.getProducts();
    }

    public List<Product> getProductInventroy() {
        return this.productInventory;
    }

    public List<Currency> getCurrencyInventory() {
        return this.currencyInventory;
    }
}
