package com.sample;

/**
 * Created by locle on 2/27/14.
 */
public class HashTable {
    protected LinkedList[] table;
    private int size = 20;

    public HashTable() {
        table = new LinkedList[size];
        for (int index = 0; index < size; ++index)
            table[index] = null;
    }

    public HashTable(int size) {
        table = new LinkedList[size];
        for (int index = 0; index < size; ++index)
            table[index] = null;
    }

    public void insert(int toAdd) {
        int index = toAdd % size;
        if (table[index] == null) {
            table[index] = new LinkedList();
            table[index].insert(toAdd);
        } else
            table[index].insert(toAdd);
    }

    public void display() {
        for (int index = 0; index < size; ++index) {
            if (table[index] != null)
                table[index].display();
        }
    }

    public boolean find(int toFind) {
        int index = toFind % size;
        if (table[index] == null) return false;
        else return table[index].find(toFind);
    }

    public void remove(int toRemove) {
        int index = toRemove % size;
        if (table[index] == null) ;
        else {
            if (table[index].sizeLinkedList() == 1) table[index] = null;
            else table[index].remove(toRemove);
        }
    }
}
