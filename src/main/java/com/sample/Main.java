package com.sample;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/5/14.
 */
public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        AVLTree tree = new AVLTree();
        for(int num=0; num < 10000000; ++num ){
            tree.insert(Integer.parseInt(randomNumeric(7)));
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

//        LinkedList list = new LinkedList();
//        list.insert(1);
//        list.insert(2);
//        list.insert(3);
//        list.insert(4);
//        list.insert(5);
//        list.insert(6);
//        list.display();
//        list.remove(3);
//        list.display();
//        System.out.println("Size of LLL " + list.sizeLinkedList());


//        HashTable table = new HashTable();
//        table.insert(0);
//        table.insert(1);
//        table.insert(2);
//        table.insert(3);
//        table.insert(4);
//        table.insert(5);
//        table.insert(6);
//        table.insert(7);
//        table.insert(8);
//        table.insert(9);
//        table.insert(10);
//        table.insert(11);
//        table.insert(12);
//        table.insert(13);
//        table.insert(14);
//        table.insert(15);
//        table.insert(16);
//        table.insert(17);
//        table.insert(18);
//        table.insert(19);
//        table.insert(0);
//        table.insert(20);
//        table.insert(40);
//        table.insert(60);
//        table.display();
//        table.remove(19);
//        table.remove(20);
//        table.remove(40);
//        table.display();
//        System.out.println(table.find(18));
//        System.out.println(table.find(21));



    }
}
