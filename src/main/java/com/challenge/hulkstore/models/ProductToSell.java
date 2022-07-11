package com.challenge.hulkstore.models;

public class ProductToSell extends Product{

    private int quantity;

    public ProductToSell(long id, String description, float price, int stock, long franchiseId, long userId, int quantity) {
        super(id, description, price, stock, franchiseId, userId);
        this.quantity = quantity;
    }

    public ProductToSell(String description, float price, int stock, long franchiseId, long userId, int quantity) {
        super(description, price, stock, franchiseId, userId);
        this.quantity = quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotal() {
        return this.getPrice() * this.quantity;
    }
}
