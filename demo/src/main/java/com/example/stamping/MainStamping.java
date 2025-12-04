package com.example.stamping;



public class MainStamping {
    public static void main(String[] args) {

        Signature<Integer> s1 = new Signature<>(x -> System.out.println("Value: " + x));
        Signature<Integer> s2 = new Signature<>(x -> System.out.println("Square: " + (x * x)));

        Group<Integer> group = new Group<>();
        group.addTask(s1).addTask(s2);

        group.apply(10);

        System.out.println("Group stamps: " + group.getStamps());
        System.out.println("Signature 1 stamps: " + s1.getStamps());
        System.out.println("Signature 2 stamps: " + s2.getStamps());
    }
}

