package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product model) {
        return productRepository.save(model);
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public boolean remove(Long id) {
        Product product = getOne(id);
        if (product != null) {
            productRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeAll() {
        return false;
    }
}