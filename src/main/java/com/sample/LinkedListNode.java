package com.sample;

/**
 * Created by locle on 2/27/14.
 */
public class LinkedListNode {

   protected int data;
   protected LinkedListNode next;

    public LinkedListNode(){
        this.data = 0;
        this.next = null;
    }

    public LinkedListNode(int toAdd){
        this.data = toAdd;
        this.next = null;
    }

}
