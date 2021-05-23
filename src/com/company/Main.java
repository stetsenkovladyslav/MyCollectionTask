package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Object> myArrayList = new MyArrayList<>();
        List<Object> arrayList = new ArrayList<>();
        List<Object> myLinkedList = new MyLinkedList<>();
        List<Object> linkedList = new LinkedList<>();
        for (int i = 0; i < 500000; i++) {
            myArrayList.add(new Object());
            arrayList.add(new Object());
            linkedList.add(new Object());
            myLinkedList.add(new Object());
        }
        long timer = System.currentTimeMillis();
        arrayList.add(0, new Object());
        timer = System.currentTimeMillis() - timer;
        System.out.println("ArrayList time: " + timer);
        timer = System.currentTimeMillis();
        myArrayList.add(0, new Object());
        timer = System.currentTimeMillis() - timer;
        System.out.println("MyArrayList time: " + timer);

        timer = System.currentTimeMillis();
        linkedList.add(0, new Object());
        timer = System.currentTimeMillis() - timer;
        System.out.println("LinkedList time: " + timer);
        timer = System.currentTimeMillis();
        myLinkedList.add(0, new Object());
        timer = System.currentTimeMillis() - timer;
        System.out.println("MyLinkedList time: " + timer);
    }
}
