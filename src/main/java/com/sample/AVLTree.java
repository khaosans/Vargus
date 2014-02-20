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

    private Node find(int toFind, Node root){
        while(root!=null){
            if(toFind.compareTo(root.data) <0){
                root = root.left;
            }
            else if(toFind.compareTo(root.data) >0){
                root = root.right;
            }
            else
                return root;
        }
    public boolean find(int toFind){
        return (toFind == find(toFind, root).data);
    }
    }

}
