package com.sample;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/25/14.
 */
public class AVLTreeTest extends TestCase {
    private AVLTree aTree;
    final public int SIZEOFTREE = 30;
    final public int NUMBERSIZE = 4;

    public void initTree(){
        aTree = new AVLTree();
    }

    @Test
    public void testIsEmpty() throws Exception {
        initTree();
        assertTrue(aTree.isEmpty());
        aTree.insert(Integer.parseInt(randomNumeric(NUMBERSIZE)));
        assertFalse(aTree.isEmpty());
    }

    @Test
    public void testInsert() throws Exception {
        initTree();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int number;

        for (int i=0; i<SIZEOFTREE;++i){
            number = Integer.parseInt(randomNumeric(NUMBERSIZE));
            stack1.push(number);
            stack2.push(number);
            aTree.insert(stack1.pop());
        }
        for (int i=0; i<SIZEOFTREE;++i){
            assertTrue(aTree.find(stack2.pop()));
        }
    }

    @Test
    public void testRemove() throws Exception {
        initTree();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int number,valueToFind;

        for (int i=0; i<SIZEOFTREE;++i){
            number = Integer.parseInt(randomNumeric(NUMBERSIZE));
            stack1.push(number);
            stack2.push(number);
            aTree.insert(stack1.pop());
        }
        //Less one for empty tree
        for (int j=0; j<SIZEOFTREE-1;++j){
            valueToFind = stack2.pop();
            aTree.remove(valueToFind);
            assertFalse(aTree.find(valueToFind));
        }
        System.out.println("last number on stack: "+stack2.peek());
        System.out.println("Print the Tree here");
        aTree.display();
        System.out.println("Try to remove the last number here");
        aTree.remove(stack1.peek());
    }

    @Test
    public void testFind() throws Exception {
    }
}
