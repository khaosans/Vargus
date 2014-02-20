package com.sample;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/5/14.
 */
public class MainTest {
    @Test
    public void testTest() throws Exception{
        AVLTree tree = new AVLTree();
        long startTime = System.currentTimeMillis();
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
        tree.insert(18);
        //    tree.display();
        System.out.println(tree.find(18));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}
