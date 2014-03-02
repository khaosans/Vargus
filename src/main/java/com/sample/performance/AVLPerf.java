package com.sample.performance;

import com.sample.AVLTree;

import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by solus on 3/1/14.
 */
public class AVLPerf {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int size = 10;
        int max = Integer.parseInt(randomNumeric(7));

        performanceInsertion(tree, size, max);
        performanceDelete(tree, size, max);
    }

    public static void performanceInsertion(AVLTree tree, int size, int max) {
        for (int i = 0; i < size; ++i) {
            Stack<Integer> stack1 = new Stack<Integer>();
            int number;
            long startTime = System.currentTimeMillis();
            for (int index = 0; index < max; ++index) {
                number = Integer.parseInt(randomNumeric(7));
                stack1.add(number);
                tree.insert(number);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("number of operation insertion " + max + " spends" + (startTime - endTime) + " ms");
        }
    }

    public static void performanceDelete(AVLTree tree, int size, int max) {
        for (int i = 0; i < size; ++i) {
            Stack<Integer> stack1 = new Stack<Integer>();
            int number;
            for (int index = 0; index < max; ++index) {
                number = Integer.parseInt(randomNumeric(7));
                stack1.add(number);
                tree.insert(number);
            }
            long startTime = System.currentTimeMillis();
            for (int index = 0; index < max; ++index) {
                tree.insert(stack1.pop());
            }
            long endTime = System.currentTimeMillis();
            System.out.println("number of operation deletion " + max + " spends" + (startTime - endTime) + " ms");
        }
    }
}
