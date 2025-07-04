package com.mycompany.fawrytask;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public static void checkout(Customer cust, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        double subtotal = 0;
        List<Item> toShip = new ArrayList<>();

        for (Item item : cart.getItems()) {
            Product p = item.getProduct();
            if (p.isExpired()) {
                throw new IllegalStateException(p.getName() + " is expired");
            }
            if (item.getNumber() > p.getQuantity()) {
                throw new IllegalStateException(p.getName() + " is out of stock");
            }
            subtotal += p.getPrice() * item.getNumber();
            p.reduceQuantity(item.getNumber());

            if (p instanceof Shippable) {
                toShip.add(item);
            }
        }

        double totalWeightKg = toShip.stream()
            .mapToDouble(ci -> ((Shippable)ci.getProduct()).getWeight() * ci.getNumber())
            .sum() / 1000.0;
        double shippingFee = toShip.isEmpty() ? 0 : ShippingService.calculateShippingFee(totalWeightKg);
        double totalAmount = subtotal + shippingFee;

        if (cust.getBalance() < totalAmount) {
            throw new IllegalStateException("Insufficient balance");
        }

        if (!toShip.isEmpty()) {
            ShippingService.ship(toShip);
        }

        System.out.println("** Checkout receipt **");
        for (Item item : cart.getItems()) {
            System.out.printf("%dx %s    %.0f%n", item.getNumber(), item.getProduct().getName(),
                              item.getProduct().getPrice() * item.getNumber());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal    %.0f%n", subtotal);
        System.out.printf("Shipping    %.0f%n", shippingFee);
        System.out.printf("Amount      %.0f%n", totalAmount);

        cust.deductBalance(totalAmount);
    }
}
