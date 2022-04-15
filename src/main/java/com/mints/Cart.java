package com.mints;

import com.mints.entity.Product;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Cart implements Serializable {
    private Map<Product, Integer> products;

    public Cart() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product))
            products.put(product, products.get(product) + 1);
        else
            products.put(product, 1);
    }

    public int getCount(Product product) {
        return products.get(product);
    }

    public int getCount()
    {
        AtomicInteger totalCount = new AtomicInteger();
        products.keySet().forEach((product) -> {
            totalCount.addAndGet(getCount(product));
        });
        return totalCount.get();
    }

    public int getProductTotalPrice(Product product) {
        return product.getPrice() * getCount(product);
    }

    public int getProductTotalPrice() {
        AtomicInteger totalPrice = new AtomicInteger();
        products.keySet().forEach((product) -> {
            totalPrice.addAndGet(getProductTotalPrice(product));
        });
        return totalPrice.get();
    }
}
