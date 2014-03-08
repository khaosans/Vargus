package com.sample.performance;

import com.sample.HashTable;

import java.util.LinkedList;
import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by locle on 3/5/14.
 */
public class HashtableMetrics extends Metrics{
    public static long hashtableInsertions(int size, int numberOfInsertions) {
        HashTable table = new HashTable(size);
        nameOfTest = "Hastable";
        typeOfTest = "Insertion";
        int number;
        long startTime;
        long endTime;
        long totalTime = 0;

        for (int i = 0; i < numberOfInsertions; ++i) {
            number = Integer.parseInt(randomNumeric(7));
            startTime = System.currentTimeMillis();
            table.insert(number);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime;
    }
    public Metrics testOfInsertion(int size,int start, int increment, int end) {
        numberOfElements = new LinkedList<Long>();
        timeForOperation = new LinkedList<Long>();

        while (start < end) {
            timeForOperation.add(hashtableInsertions(size, start));
            numberOfElements.add((long) start);
            start += increment;
        }
        return this;
    }

    public static long hashtableDeletions(int size, int numberOfDeletionss) {
        HashTable table = new HashTable(size);
        nameOfTest = "Hastable";
        typeOfTest = "Deletion";
        int number;
        long startTime;
        long endTime;
        long totalTime = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < numberOfDeletionss; ++i) {
            number = Integer.parseInt(randomNumeric(7));
            stack.push(number);
            table.insert(number);
        }

        for (int i = 0; i < numberOfDeletionss; ++i) {
            startTime = System.currentTimeMillis();
            table.remove(stack.pop());
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime;
    }

    public Metrics testOfDeletions(int size, int start, int increment, int end) {
        numberOfElements = new LinkedList<Long>();
        timeForOperation = new LinkedList<Long>();

        while (start < end) {
            timeForOperation.add(hashtableDeletions(size, start));
            numberOfElements.add((long) start);
            start += increment;
        }
        return this;
    }

    public static long hashtableFound(int size, int numberOfDeletionss) {
        HashTable table = new HashTable(size);
        nameOfTest = "Hastable";
        typeOfTest = "Found";
        int number;
        long startTime;
        long endTime;
        long totalTime = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < numberOfDeletionss; ++i) {
            number = Integer.parseInt(randomNumeric(7));
            stack.push(number);
            table.insert(number);
        }

        for (int i = 0; i < numberOfDeletionss; ++i) {
            startTime = System.currentTimeMillis();
            table.find(stack.pop());
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        return totalTime;
    }

    public Metrics testOfFound(int size, int start, int increment, int end) {
        numberOfElements = new LinkedList<Long>();
        timeForOperation = new LinkedList<Long>();

        while (start < end) {
            timeForOperation.add(hashtableFound(size, start));
            numberOfElements.add((long) start);
            start += increment;
        }
        return this;
    }
}
