package com.mints.service;

import com.mints.entity.Product;
import com.mints.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAll()
    {
        return repository.findAll();
    }

    public Product getByName(String name)
    {
        return getAll().stream().filter(product -> product.getName().equals(name)).findAny().orElse(null);
    }
}
