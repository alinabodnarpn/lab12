package com.example.atm;


public class ConcreteCoinHandler extends CoinHandler {
    private final int denom;

    public ConcreteCoinHandler(int denom) {
        this.denom = denom;
    }

    @Override
    public void handle(int amount, ChangeResult result) {
        if (amount >= denom) {
            int count = amount / denom;
            result.add(denom, count);
            amount = amount % denom;
        }

        if (amount > 0 && next != null) {
            next.handle(amount, result);
        } else if (amount > 0) {
            result.markImpossible();
        }
    }
}
