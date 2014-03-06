package com.sample.performance;

import com.sample.HashTable;

import java.util.LinkedList;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by locle on 3/5/14.
 */
public class HashtableMetrics extends Metrics{
    public static long hashtableInsertions(int numberOfInsertions) {
        HashTable table = new HashTable(100);
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
    public Metrics testOfInsertion(int start, int increment, int end) {
        numberOfElements = new LinkedList<Long>();
        timeForOperation = new LinkedList<Long>();

        while (start < end) {
            timeForOperation.add(hashtableInsertions(start));
            numberOfElements.add((long) start);
            start += increment;
        }

        return this;
    }

}
