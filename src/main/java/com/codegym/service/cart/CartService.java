package com.codegym.service.cart;

import com.codegym.model.CartProduct;
import com.codegym.model.Product;

import java.util.List;

public class CartService implements ICartService {

    @Override
    public int getTotalQuantity(List<Product> products) {
        int totalQuantity = 0;
        for (Product product : products) {
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;
    }

    @Override
    public float getTotalPrice(List<Product> products) {
        float totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getQuantity() * product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public boolean isExists(Long id, List<Product> products) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Product findOne(Long id, List<Product> products) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Long id, List<Product> products) {
        Product product = findOne(id, products);
        if (product != null) {
            products.remove(product);
            return true;
        } else {
            return false;
        }
    }
}