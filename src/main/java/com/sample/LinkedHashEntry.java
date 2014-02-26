package com.sample;

/**
 * Created by locle on 2/26/14.
 */
public class LinkedHashEntry {
    private int data;
    private LinkedHashEntry next;

    LinkedHashEntry(int value) {
        this.data = value;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedHashEntry getNext() {
        return next;
    }

    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }
}
