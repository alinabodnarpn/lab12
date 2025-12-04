package com.example.atm;

import java.util.Arrays;

public class MainATM {
    public static void main(String[] args) {
        ATM atm = new ATM(Arrays.asList(200, 100, 50, 20, 10));

        Result result = atm.withdraw(380);
        System.out.println("Coins: " + result);

        // Not possible case:
        try {
            atm.withdraw(385);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
