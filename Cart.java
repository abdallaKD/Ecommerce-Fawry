package com.mycompany.fawrytask;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items = new ArrayList<>();
    private double totalPrice = 0;

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("sorry cannot add " + quantity + " of " + product.getName() + " only " + product.getQuantity() + " available.");
            return;
        }
        items.add(new Item(product, quantity));
        totalPrice = totalPrice + (product.getPrice() * quantity);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
