package com.example.atm;

public abstract class Handler {
    protected Handler next;

    public Handler linkWith(Handler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(int amount, Result result);
}
