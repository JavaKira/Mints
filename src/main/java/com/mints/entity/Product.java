package com.mints.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    private int id;

    private String name;
    private String description;
    private String thumbnailPath;
    private int price;

    public Product(int id, String name, String description, String thumbnailPath, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnailPath = thumbnailPath;
        this.price = price;
    }
}
