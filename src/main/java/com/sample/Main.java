package com.sample;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/5/14.
 */
public class Main {
    public static void main(String[] args) {

//        long startTime = System.currentTimeMillis();
        AVLTree tree = new AVLTree();
        tree.insert(3);
//        tree.insert(2);
//        tree.insert(1);
//        tree.insert(4);
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(7);
//        tree.insert(16);
//        tree.insert(15);
//        tree.insert(14);
        tree.display();
        tree.remove(3);
        tree.display();
//        System.out.println(tree.find(16));
//        tree.insert(Integer.parseInt(randomNumeric(2)));
//        tree.insert(Integer.parseInt(randomNumeric(2)));
//        tree.insert(Integer.parseInt(randomNumeric(2)));
//        tree.insert(Integer.parseInt(randomNumeric(2)));
//        tree.insert(Integer.parseInt(randomNumeric(2)));
//        tree.insert(Integer.parseInt(randomNumeric(2)));
//        tree.insert(Integer.parseInt(randomNumeric(2)));
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);


        HashTable table = new HashTable();
        table.insert(0);
        table.insert(1);
        table.insert(2);
        table.insert(3);
        table.insert(4);
        table.insert(5);
        table.insert(6);
        table.insert(7);
        table.insert(8);
        table.insert(9);
        table.insert(10);
        table.insert(11);
        table.insert(12);
        table.insert(13);
        table.insert(14);
        table.insert(15);
        table.insert(16);
        table.insert(17);
        table.insert(18);
        table.insert(19);
        table.insert(0);
        table.insert(20);
        table.insert(40);
        table.insert(60);
        table.display();


    }
}
