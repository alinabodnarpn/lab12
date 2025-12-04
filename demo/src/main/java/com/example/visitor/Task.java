package com.example.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Task<T> {
    private final String id = UUID.randomUUID().toString();
    private final Map<String, String> headers = new HashMap<>();

    public abstract void apply(T arg);

    public void setHeader(String k, String v) {
        headers.put(k, v);
    }

    public String getHeader(String k) {
        return headers.get(k);
    }

    public String getId() {
        return id;
    }
}
