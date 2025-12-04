package com.example.atm;

public class CoinHandler extends Handler {

    private final int denomination;

    public CoinHandler(int denomination) {
        this.denomination = denomination;
    }

    @Override
    public void handle(int amount, Result result) {
        int count = amount / denomination;
        if (count > 0) {
            result.addCoins(denomination, count);
            amount -= denomination * count;
        }

        if (amount > 0) {
            if (next != null) {
                next.handle(amount, result);
            } else {
                throw new RuntimeException("Cannot produce exact amount. Remaining: " + amount);
            }
        }
    }
}
