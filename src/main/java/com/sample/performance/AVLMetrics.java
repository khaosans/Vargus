package com.sample.performance;

import com.sample.AVLTree;
import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by solus on 3/1/14.
 */
public class AVLMetrics extends Metrics {

    private static AVLTree tree;

    public static void main(String[] args) {
        System.out.println(avlInsertions(20000000));
    }

    public static void initializeTree() {
        tree = new AVLTree();
    }

    public static long avlInsertions(int numberOfInsertions) {
        initializeTree();
        int number;
        long startTime;
        long endTime;
        long totalTime = 0;

        for (int i = 0; i < numberOfInsertions; ++i) {
            number = Integer.parseInt(randomNumeric(7));
            startTime = System.currentTimeMillis();
            tree.insert(number);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime;
    }

    public Metrics testOfInsertion(int start, int increment, int end) {
        numberOfElements = new LinkedList<Long>();
        timeForOperation = new LinkedList<Long>();

        while (start < end) {
            timeForOperation.add(avlInsertions(start));
            numberOfElements.add((long) start);
            start += increment;
        }
        return this;
    }

    public static long avlDeletions(int numberOfDeletions) {
        initializeTree();
        int number;
        long startTime;
        long endTime;
        long totalTime = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < numberOfDeletions; ++i) {
            number = Integer.parseInt(randomNumeric(7));
            stack.push(number);
            tree.insert(number);
        }

        for (int i = 0; i < numberOfDeletions; ++i) {
            startTime = System.currentTimeMillis();
            tree.remove(stack.pop());
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime;
    }

    public Metrics testOfDeletions(int start, int increment, int end) {
        numberOfElements = new LinkedList<Long>();
        timeForOperation = new LinkedList<Long>();

        while (start < end) {
            timeForOperation.add(avlDeletions(start));
            numberOfElements.add((long) start);
            start += increment;
        }
        return this;
    }

    public static long avlFounds(int numberOfFound) {
        initializeTree();
        int number;
        long startTime;
        long endTime;
        long totalTime = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < numberOfFound; ++i) {
            number = Integer.parseInt(randomNumeric(7));
            stack.push(number);
            tree.insert(number);
        }

        for (int i = 0; i < numberOfFound; ++i) {
            startTime = System.currentTimeMillis();
            tree.find(stack.pop());
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime;
    }

    public Metrics testOfFounds(int start, int increment, int end) {
        numberOfElements = new LinkedList<Long>();
        timeForOperation = new LinkedList<Long>();

        while (start < end) {
            timeForOperation.add(avlFounds(start));
            numberOfElements.add((long) start);
            start += increment;
        }
        return this;
    }
}