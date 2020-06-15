package com.codegym.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private int totalQuantity;
    private float totalPrice;

    public Cart() {
        products = new ArrayList<>();
        totalQuantity = 0;
        totalPrice = 0;
    }

    public Cart(List<Product> products, int totalQuantity, float totalPrice) {
        this.products = products;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}