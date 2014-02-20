package com.sample;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/5/14.
 */
public class Main {
    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
     //   long startTime = System.currentTimeMillis();

        tree.insert(18);
        tree.insert(23);
        tree.insert(15);
    //    tree.insert(18);
            tree.display();
 //       System.out.println(tree.find(18));
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
    //    System.out.println(totalTime);


    }
}
