package com.codegym.service.cart;

import com.codegym.model.CartProduct;
import com.codegym.model.Product;

import java.util.List;

public interface ICartService {
    int getTotalQuantity(List<Product> products);

    float getTotalPrice(List<Product> products);

    boolean isExists(Long id, List<Product> products);

    Product findOne(Long id, List<Product> products);

    boolean remove(Long id, List<Product> products);
}
