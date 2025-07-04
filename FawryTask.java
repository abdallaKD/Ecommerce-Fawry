package com.mycompany.fawrytask;

import java.time.LocalDate;

public class FawryTask {

    public static void main(String[] args) {
        ShippableProduct cheese = new ShippableProduct("Cheese", 100, 5, LocalDate.now().plusDays(5), 400);
        ShippableProduct tv = new ShippableProduct("TV", 5000, 2, 10000);

        Customer cust = new Customer("Bob", 10000, "Cairo");
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv, 1);

        CheckoutService.checkout(cust, cart);
    }
}
