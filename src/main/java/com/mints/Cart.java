package com.mints;

import com.mints.entity.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Cart implements Serializable {
    private Map<Product, Integer> products;

    public Cart() {
        products = new HashMap<>();
    }

    public void addProduct(Product product)
    {
        if (products.containsKey(product))
            products.put(product, products.get(product) + 1);
        else
            products.put(product, 1);
    }

    public int getCount(Product product)
    {
        return products.get(product);
    }

    public int getProductTotalPrice(Product product)
    {
        return product.getPrice() * getCount(product);
    }
}
