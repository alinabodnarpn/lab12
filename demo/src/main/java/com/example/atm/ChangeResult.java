package com.example.atm;



import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeResult {
    private final Map<Integer, Integer> coins = new LinkedHashMap<>();
    private boolean isPossible = true;

    public void add(int denom, int count) {
        coins.put(denom, count);
    }

    public void markImpossible() {
        isPossible = false;
    }

    public boolean isPossible() {
        return isPossible;
    }

    public Map<Integer, Integer> getCoins() {
        return coins;
    }
}
