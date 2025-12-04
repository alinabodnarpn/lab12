package com.example.visitor;

import java.util.*;

public class Group<T> extends Task<T> {
    private final List<Task<T>> tasks = new ArrayList<>();
    private final String groupId = UUID.randomUUID().toString();

    public Group<T> addTask(Task<T> t) {
        tasks.add(t);
        return this;
    }

    @Override
    public void apply(T arg) {
        int index = 0;

        for (Task<T> t : tasks) {
            t.setHeader("group_id", groupId);
            t.setHeader("group_index", String.valueOf(index));
            t.apply(arg);
            index++;
        }
    }
}
