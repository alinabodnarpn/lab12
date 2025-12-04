package com.example.stamping;

import java.util.HashMap;
import java.util.Map;

public abstract class Task<T> {

    protected boolean frozen = false;
    protected Map<String, Object> headers = new HashMap<>();

    public void freeze() {
        if (!frozen) frozen = true;
    }

    public void stamp(String key, Object value) {
        headers.put(key, value);
    }

    public Map<String, Object> getStamps() {
        return headers;
    }

    public abstract void apply(T arg);
}
