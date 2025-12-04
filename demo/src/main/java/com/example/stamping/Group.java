package com.example.stamping;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group<T> extends Task<T> {

    private List<Task<T>> tasks = new ArrayList<>();
    private String groupId;

    public Group<T> addTask(Task<T> task) {
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        groupId = UUID.randomUUID().toString();
        headers.put("groupId", groupId);
        for (Task<T> t : tasks) t.freeze();
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        tasks = Collections.unmodifiableList(tasks);

        for (Task<T> t : tasks) {
            t.stamp("groupId", groupId);
            t.apply(arg);
        }
    }
}
