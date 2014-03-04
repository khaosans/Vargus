package com.sample.performance;

import com.sample.AVLTree;

import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by solus on 3/1/14.
 */
public class AVLPerf {

    protected AVLTree tree;
    protected int numberOfRepeatTest;
    protected int[] inputInsert;
    protected int[] timeInsert;
    protected int[] inputDelete;
    protected int[] timeDelete;

    public AVLPerf(int numRepeat, int startNum, int increment){
        this.tree = new AVLTree();
        this.numberOfRepeatTest = numRepeat;
        this.inputInsert = new int[numRepeat];
        this.timeInsert = new int[numRepeat];

        for(int i=0; i<numRepeat; ++i){
            inputInsert[i] = startNum;
            timeInsert[i] = performanceInsertion(tree, inputInsert[i]);
            startNum += increment;
        }
        this.inputDelete = new int[numRepeat];
        this.timeDelete = new int[numRepeat];
        for(int i=0; i<numRepeat; ++i){
            inputDelete[i] = startNum;
            timeDelete[i] = performanceDelete(tree, inputDelete[i]);
            startNum += increment;
        }
    }

    public static int performanceInsertion(AVLTree tree, int max) {
        Stack<Integer> stack1 = new Stack<Integer>();
        int number;
        long startTime = System.currentTimeMillis();
        for (int index = 0; index < max; ++index) {
            number = Integer.parseInt(randomNumeric(7));
            stack1.add(number);
            tree.insert(number);
        }
        long endTime = System.currentTimeMillis();
        return (int) (endTime - startTime);
    }

    public static int performanceDelete(AVLTree tree, int max) {
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
        return (int) (endTime - startTime);
    }
}
