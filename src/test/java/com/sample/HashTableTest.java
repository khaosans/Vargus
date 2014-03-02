package com.sample;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/27/14.
 */
public class HashTableTest {
    private HashTable hashTable;
    private int MAXVALUE = 50;
    private int NUMBERSIZE = 2;
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    @Test
    public void testInsert() throws Exception {
        hashTable = new HashTable();
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

        int number;
        for (int i = 0; i < MAXVALUE; ++i) {
            number = Integer.parseInt(randomNumeric(NUMBERSIZE));
            stack1.push(number);
            stack2.push(number);
            hashTable.insert(stack1.pop());
        }
        for (int i = 0; i < MAXVALUE; ++i) {
            assertTrue(hashTable.find(stack2.pop()));
        }
    }

    @Test
    public void testRemove() throws Exception {
        hashTable = new HashTable();
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

        int number, value;
        for (int i = 0; i < MAXVALUE; ++i) {
            number = Integer.parseInt(randomNumeric(NUMBERSIZE));
            stack1.push(number);
            stack2.push(number);
            hashTable.insert(stack1.pop());
        }
        for (int i = 0; i < MAXVALUE; ++i) {
            value = stack2.pop();
            hashTable.remove(value);
            assertFalse(hashTable.find(value));
        }
    }
}
