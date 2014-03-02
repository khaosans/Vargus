package com.sample;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by souriyakhaosanga on 2/25/14.
 */
public class NodeTest {
    private Node aNode;

    @Test
    public void testNode() throws Exception {
        int number = Integer.parseInt(randomNumeric(4));
        aNode = new Node(number, null, null);
        assertEquals(number, aNode.data);
    }
}
