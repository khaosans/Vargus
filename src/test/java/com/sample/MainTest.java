package com.sample;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * Created by souriyakhaosanga on 2/5/14.
 */
public class MainTest extends AVLTree {
    private static int[] array;
    private static int maxValue;

    @Test
    public void testMain() {

    }

    @Test
    public void testTest() throws Exception {

        buildArray();
        randomizeArray(array);

        Stack<Integer> stack = new Stack();
        Stack<Integer> copy = new Stack();

        for (int i = 0; i < maxValue; ++i) {
            AVLTree tree = new AVLTree();
            stack.push(array[i]);
            copy.push(array[i]);
            tree.insert(stack.pop());
        }


    }

    public static int[] buildArray() {
        array = new int[maxValue];
        for (int i = 0; i < maxValue; ++i) {
            array[i] = i;
        }
        return array;
    }

    public static int[] randomizeArray(int[] array) {
        Random regen = new Random();  // Random number generator

        for (int i = 0; i < array.length; i++) {
            int randomPosition = regen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

}
