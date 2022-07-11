package com.challenge.hulkstore.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Builder
public class Product {
    @ApiModelProperty(notes = "Product ID",
            example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private float price;
    private int stock;
    private long franchiseId;
    private long userId;

    public Product() {
    }

    public Product(long id, String description, float price, int stock, long franchiseId, long userId) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.franchiseId = franchiseId;
        this.userId = userId;
    }

    public Product(String description, float price, int stock, long franchiseId, long userId) {
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.franchiseId = franchiseId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(long franchiseId) {
        this.franchiseId = franchiseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void reduceStock(int stock) {
        this.stock -= stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", franchiseId=" + franchiseId +
                ", userId=" + userId +
                '}';
    }
}
