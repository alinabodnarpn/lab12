package com.example.stamping;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StampingTest {

    @Test
    void testSignatureStamping() {
        Signature<Integer> s = new Signature<>(x -> {});
        s.apply(5);

        assertTrue(s.getStamps().containsKey("signatureId"));
    }

    @Test
    void testGroupStamping() {
        Signature<Integer> s1 = new Signature<>(x -> {});
        Signature<Integer> s2 = new Signature<>(x -> {});

        Group<Integer> group = new Group<>();
        group.addTask(s1).addTask(s2);

        group.apply(10);

        assertTrue(group.getStamps().containsKey("groupId"));

        assertEquals(
                group.getStamps().get("groupId"),
                s1.getStamps().get("groupId")
        );

        assertEquals(
                group.getStamps().get("groupId"),
                s2.getStamps().get("groupId")
        );
    }

    @Test
    void testNestedGroup() {
        Signature<Integer> innerSig = new Signature<>(x -> {});
        Group<Integer> inner = new Group<>();
        inner.addTask(innerSig);

        Signature<Integer> outSig = new Signature<>(x -> {});
        Group<Integer> outer = new Group<>();
        outer.addTask(inner).addTask(outSig);

        outer.apply(7);

        assertTrue(outer.getStamps().containsKey("groupId"));
        assertTrue(inner.getStamps().containsKey("groupId"));
        assertTrue(innerSig.getStamps().containsKey("groupId"));
        assertTrue(outSig.getStamps().containsKey("groupId"));
    }
}
