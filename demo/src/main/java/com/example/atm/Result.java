package com.example.atm;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private Map<Integer, Integer> coins = new LinkedHashMap<>();

    public void addCoins(int denom, int count) {
        coins.put(denom, count);
    }

    public Map<Integer, Integer> getCoins() {
        return coins;
    }

    @Override
    public String toString() {
        return coins.toString();
    }
}
