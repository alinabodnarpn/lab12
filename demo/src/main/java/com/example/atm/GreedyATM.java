package com.example.atm;
import java.util.ArrayList;
import java.util.List;

public class GreedyATM {
    private CoinHandler chain;

    public GreedyATM(List<Integer> denoms) {
        List<Integer> sorted = new ArrayList<>(denoms);
        sorted.sort((a, b) -> b - a); 
        CoinHandler prev = null;
        for (int d : sorted) {
            CoinHandler handler = new ConcreteCoinHandler(d);
            if (prev != null) prev.setNext(handler);
            else chain = handler;
            prev = handler;
        }
    }

    public ChangeResult makeChange(int amount) {
        ChangeResult result = new ChangeResult();
        chain.handle(amount, result);
        return result;
    }
}

