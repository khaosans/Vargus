package com.sample;

/**
 * Created by locle on 2/19/14.
 */
public class AVLTree {

    protected Node root;
    //constructor
    public AVLTree(){
        root = null;
    }
    //constructor with argument
//    public AVLTree(int to_add){
//        root.data = to_add;
//        root.left = null;
//        root.right = null;
//    }
//    function check the empty tree or not
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * function find the height of root
     * @param t
     * @return height of node, or -1 if null
     */
    private int height(Node t) // return height of node t, or -1, if null.
    {
        if (t == null)
            return -1;
        else
            return t.height;
    }

	/*
	 * Insert into the tree; duplicates are ignored. x the item to insert.
	 */

    public void insert(int x) {
        root = insert(x, root);
    }

	/*
	 * method to insert into a subtree. x the item to insert. t the node that
	 * roots the subtree. return the new root of the subtree.
	 */

    private Node insert(int x, Node t) {
        // root is null
        if (t == null)
            return t = new Node(x);
        else {
            if (x < t.data) {
                t.left = insert(x, t.left);
                if(height(t.left)- height(t.right) == 2){
                    if(x < t.left.data){
                        t = rotateLeft(t);
                    }
                    else{
                        t = doubleLeft(t);
                    }
                }
            } else if (x > t.data) {
                t.right = insert(x, t.right);
                if(height(t.right)- height(t.left) == 2){
                    if(x > t.right.data){
                        t = rotateRight(t);
                    }
                    else{
                        t = doubleRight(t);
                    }
                }
            }
        }

        return t;

    }
    /**
     * Single rotation for AVL tree with left child and update height
     * @param current
     * @return new root
     */
    private Node rotateLeft(Node current) {
        Node temp = current.left;
        current.left = temp.right;
        temp.right = current;
        current.height = Math.max(height(current.left), height(current.right)) + 1;
        temp.height = Math.max(height(temp.left), current.height) + 1;
        return temp;
    }

    /**
     * Single rotation for AVL tree with right child and update height
     * @param current
     * @return new root
     */
    private Node rotateRight(Node current) {
        Node temp = current.right;
        current.right = temp.left;
        temp.left = current;
        current.height = Math.max(height(current.left), height(current.right)) + 1;
        temp.height = Math.max(height(temp.right), current.height) + 1;
        return temp;
    }
    /**
     * first left child with its right child
     * @param current is new left child
     * @return new root
     */
    private Node doubleLeft(Node current) {
        current.left = rotateRight(current.left);
        return rotateLeft(current);
    }

    /**
     * first left child with its left child
     * @param current is new right child
     *
     * @return new root
     */
    private Node doubleRight(Node node1) {
        node1.right = rotateLeft(node1.right);
        return rotateRight(node1);
    }

    //wrap up function display in sorted order
    public void display() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            display(root);
    }

    //display tree in sorted order
    private void display(Node t)
    {
        if (t != null) {
            display(t.left);
            System.out.println(t.data);
            display(t.right);
        }
    }

    //Removes a node from the tree, if it is existent.
    public void remove(int toRemove) {
        // First we must find the node, after this we can delete it.
        removeAVL(this.root,toRemove);
    }

    public void removeAVL(Node root,int toRemove) {
        if(root==null) {
            // der Wert existiert nicht in diesem Baum, daher ist nichts zu tun
            return;
        } else {
            if(root.data>toRemove)  {
                removeAVL(root.left,toRemove);
            } else if(root.data<toRemove) {
                removeAVL(root.right, toRemove);
            } else if(root.data==toRemove) {
                // we found the node in the tree.. now lets go on!
                removeFoundNode(root);
            }
        }
    }

    public void removeFoundNode(Node q) {
        Node r;
        // at least one child of q, q will be removed directly
        if(q.left==null || q.right==null) {
            // the root is deleted
            if(q.parent==null) {
                this.root=null;
                q=null;
                return;
            }
            r = q;
        } else {
            // q has two children --> will be replaced by successor
            r = successor(q);
            q.key = r.key;
        }



}
