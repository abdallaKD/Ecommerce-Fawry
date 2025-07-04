package com.mycompany.fawrytask;

public class Customer {

    private String name;
    private double balance;
    private String location;

    public Customer(String name, double balance, String location) {
        this.name = name;
        this.balance = balance;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getLocation() {
        return this.location;
    }

    public void deductBalance(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }
}
