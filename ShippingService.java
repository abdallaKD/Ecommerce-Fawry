package com.mycompany.fawrytask;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {

    private static final double RATE_PER_KG = 15.0;

    public static void ship(List<Item> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Item item : items) {
            Shippable s = (Shippable) item.getProduct();
            System.out.printf("%dx %s        %dg%n", item.getNumber(), s.getName(), (int) s.getWeight());
            totalWeight += s.getWeight() * item.getNumber();
        }
        double totalKg = totalWeight / 1000.0;
        System.out.printf("Total package weight %.1fkg%n%n", totalKg);
    }

    public static double calculateShippingFee(double totalKg) {
        int kgRounded = (int) Math.ceil(totalKg);
        return kgRounded * RATE_PER_KG;
    }
}
