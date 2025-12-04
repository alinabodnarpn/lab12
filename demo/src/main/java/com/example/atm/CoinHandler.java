package com.example.atm;

public abstract class CoinHandler {
    protected CoinHandler next;

    public void setNext(CoinHandler next) {
        this.next = next;
    }

    public abstract void handle(int amount, ChangeResult result);
}
