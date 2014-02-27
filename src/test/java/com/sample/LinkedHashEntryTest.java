package com.sample;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

/**
 * Created by locle on 2/26/14.
 */
public class LinkedHashEntryTest extends TestCase {
    private LinkedHashEntry lllist;

    public void initList(){
        lllist = new LinkedHashEntry();
    }
    @Test
    public void testInsert() throws Exception {
        initList();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        int number = 0;
        for (int index=0; index<20; ++index){
            number = Integer.parseInt(randomNumeric(4));
            stack1.push(number);
            stack2.push(number);
        }



    }
}
