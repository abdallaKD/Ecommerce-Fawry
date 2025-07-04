package com.mycompany.fawrytask;

public class Item {

    private Product pr;
    private int number;

    public Item(Product pr, int number) {
        this.pr = pr;
        this.number = number;
    }

    public Product getProduct() {
        return this.pr;
    }

    public int getNumber() {
        return this.number;
    }
}
