package com.sample;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/25/14.
 */
public class AVLTreeTest extends TestCase {
    private AVLTree aTree;

    public void initTree(){
        aTree = new AVLTree();
    }

    @Test
    public void testIsEmpty() throws Exception {
        initTree();
        assertTrue(aTree.isEmpty());
        aTree.insert(Integer.parseInt(randomNumeric(3)));
        assertFalse(aTree.isEmpty());
    }

    public void testName() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        initTree();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        int number=0;
        for (int i=0; i<20;++i){
            number = Integer.parseInt(randomNumeric(6));

            stack.push(number);
            stack2.push(number);
            aTree.insert(stack.pop());
        }
        for (int i=0; i<20;++i){
            assertTrue(aTree.find(stack2.pop()));
        }
    }

    @Test
    public void testDisplay() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testFind() throws Exception {

    }
}
