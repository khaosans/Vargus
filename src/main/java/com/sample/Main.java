package com.sample;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/5/14.
 */
public class Main {
    public static void main(String[] args) {


//        String a = randomNumeric(1);
//        Integer.parseInt(a);
//        System.out.println(a);
//        System.out.println("hello");
        AVLTree tree = new AVLTree();
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.insert(Integer.parseInt(randomNumeric(2)));
        tree.display();


    }
}
