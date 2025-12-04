package com.example.stamping;



import java.util.UUID;
import java.util.function.Consumer;

public class Signature<T> extends Task<T> {

    private final Consumer<T> consumer;

    public Signature(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void apply(T arg) {
        this.freeze();

        headers.putIfAbsent("signatureId", UUID.randomUUID().toString());

        consumer.accept(arg);
    }
}
