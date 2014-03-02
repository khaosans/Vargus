package com.sample.performance;

import com.sample.AVLTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by solus on 3/1/14.
 */
public class AVLPerf {

    protected AVLTree tree;
    protected int size;
    protected int[] inputInsert;
    protected int[] timeInsert;
    protected int[] inputDelete;
    protected int[] timeDelete;

    public AVLPerf(){
        this.tree = new AVLTree();
        this.size = 10;
        this.inputInsert = new int[size];
        this.timeInsert = new int[size];
        for(int i=0; i<size; ++i){
            inputInsert[i] = Integer.parseInt(randomNumeric(7));
            timeInsert[i] = performanceInsertion(tree, inputInsert[i]);
        }
        this.inputDelete = new int[size];
        this.timeDelete = new int[size];
        for(int i=0; i<size; ++i){
            inputDelete[i] = Integer.parseInt(randomNumeric(7));
            timeDelete[i] = performanceDelete(tree, inputDelete[i]);
        }

    }

    public AVLPerf(int size, int legthOfInt){
        this.tree = new AVLTree();
        this.size = size;
        this.inputInsert = new int[size];
        this.timeInsert = new int[size];
        for(int i=0; i<size; ++i){
            inputInsert[i] = Integer.parseInt(randomNumeric(legthOfInt));
            timeInsert[i] = performanceInsertion(tree, inputInsert[i]);
        }
        this.inputDelete = new int[size];
        this.timeDelete = new int[size];
        for(int i=0; i<size; ++i){
            inputDelete[i] = Integer.parseInt(randomNumeric(legthOfInt));
            timeDelete[i] = performanceDelete(tree, inputDelete[i]);
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
