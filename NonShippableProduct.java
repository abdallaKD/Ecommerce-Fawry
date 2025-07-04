package com.mycompany.fawrytask;

import java.time.LocalDate;

public class NonShippableProduct extends Product {

    public NonShippableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity, expiryDate);
    }

    public NonShippableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
