package com.sample;

/**
 * Created by locle on 2/19/14.
 */
public class Node {
    protected Node left;
    protected Node right;
    protected int data;
    protected int height;
    //Constructor
    public Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
    //wrap up function
    public Node(int to_add){
        this(to_add, null, null);
    }
    //constructor with argument
    public Node(int to_add, Node to_left, Node to_right) {
        data = to_add;
        left = to_left;
        right = to_right;
        height = 0;
    }
}
