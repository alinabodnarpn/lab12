package com.example.atm;

import java.util.Collections;
import java.util.List;

public class ATM {

    private Handler chain;

    public ATM(List<Integer> denominations) {
        Collections.sort(denominations, Collections.reverseOrder());
        Handler first = new CoinHandler(denominations.get(0));
        Handler current = first;

        for (int i = 1; i < denominations.size(); i++) {
            current = current.linkWith(new CoinHandler(denominations.get(i)));
        }

        this.chain = first;
    }

    public Result withdraw(int amount) {
        Result result = new Result();
        chain.handle(amount, result);
        return result;
    }
}
