package com.sample;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by solus on 3/1/14.
 */
public class LinkedListTest extends TestCase {
    private LinkedList list;
    private int MAXVALUE = 50;
    private int NUMBERSIZE =2;
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    @Test
    public void testInsert() throws Exception {
        list = new LinkedList();
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

        int number;
        for(int i=0;i<MAXVALUE;++i){
            number = Integer.parseInt(randomNumeric(NUMBERSIZE));
            stack1.push(number);
            stack2.push(number);
            list.insert(stack1.pop());
        }
        for(int i=0;i<MAXVALUE;++i){
            assertTrue(list.find(stack2.pop()));
        }
    }

    @Test
    public void testFind() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {
        list = new LinkedList();
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();

        int number,valueToFind;
        for(int i=0;i<MAXVALUE;++i){
            number = Integer.parseInt(randomNumeric(NUMBERSIZE));
            stack1.push(number);
            stack2.push(number);
            list.insert(stack1.pop());
        }
        /*for(int i=0;i<MAXVALUE;++i){
            valueToFind = stack2.pop();

            System.out.println(valueToFind);
            System.out.println(list.find(valueToFind));
        }*/

        list.insert(52);
        list.insert(25);
        list.remove(52);
        list.find(52);
    }

    @Test
    public void testSizeLinkedList() throws Exception {

    }
}
