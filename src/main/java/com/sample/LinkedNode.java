package com.sample;

/**
 * Created by locle on 2/27/14.
 */
public class LinkedNode {
    protected LinkedNode next;
    protected int data;

    public LinkedNode(){
        this.data = 0;
        this.next = null;
    }

    public LinkedNode(int toAdd){
        this.data = toAdd;
        this.next = null;
    }
}
