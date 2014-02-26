package com.sample;

/**
 * Created by locle on 2/26/14.
 */
public class HashTable {
    private final static int TABLE_SIZE = 20;

    LinkedHashEntry[] table;

    public HashTable() {
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
/*
    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null)
            return -1;
        else {
            LinkedHashEntry entry = table[hash];
            while (entry != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry == null)
                return -1;
            else
                return entry.getData();
        }
    }
*/
    public void insert(int data) {
        int index = (data % TABLE_SIZE);
        if (table[index] == null){
            table[index] = new LinkedHashEntry(data);
            table[index].setData(data);
        }
        else {
            LinkedHashEntry entry = table[index];
            while (entry.getNext() != null && entry.getData() != data)
                entry = entry.getNext();
            if (entry.getData() == data)
                return;//don't allow duplicate
            else
                entry.setNext(new LinkedHashEntry(data));

        }
    }

    public void remove(int data) {
        int index = (data % TABLE_SIZE);
        if (table[index] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[index];
            while (entry.getNext() != null && entry.getData() != data) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getData() == data) {
                if (prevEntry == null)
                    table[index] = entry.getNext();
                else{
                    prevEntry.setNext(entry.getNext());
                    table[index] = prevEntry;
                }
            }
        }
    }
}
