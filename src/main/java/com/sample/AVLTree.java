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

    public boolean isEmpty() {
        return root == null;
    }

    private int height(Node t)
    {
        if (t == null)
            return -1;
        else
            return t.height;
    }

    public void insert(int toAdd) {
        root = insert(toAdd, root);
    }


    private Node insert(int toAdd, Node node) {
        if (node == null)
            return new Node(toAdd);
        else {
            if (toAdd < node.data) {
                node.left = insert(toAdd, node.left);
                if (height(node.left) - height(node.right) == 2){
                    if (toAdd < node.left.data){
                        node = rotateLeft(node);
                    }
                    else{
                        node = doubleLeft(node);
                    }
                }
            } else if (toAdd > node.data) {
                node.right = insert(toAdd, node.right);
                if (height(node.right) - height(node.left) == 2){
                    if(toAdd > node.right.data){
                        node = rotateRight(node);
                    }
                    else{
                        node = doubleRight(node);
                    }
                }
            }
        }
        return node;

    }

    private Node rotateLeft(Node current) {
        Node temp = current.left;
        current.left = temp.right;
        temp.right = current;
        current.height = Math.max(height(current.left), height(current.right)) + 1;
        temp.height = Math.max(height(temp.left), current.height) + 1;
        return temp;
    }


    private Node rotateRight(Node current) {
        Node temp = current.right;
        current.right = temp.left;
        temp.left = current;
        current.height = Math.max(height(current.left), height(current.right)) + 1;
        temp.height = Math.max(height(temp.right), current.height) + 1;
        return temp;
    }

    private Node doubleLeft(Node current) {
        current.left = rotateRight(current.left);
        return rotateLeft(current);
    }

    private Node doubleRight(Node node1) {
        node1.right = rotateLeft(node1.right);
        return rotateRight(node1);
    }


    public void display() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            display(root);
    }

    private void display(Node t)
    {
        if (t != null) {
            display(t.left);
            System.out.println(t.data);
            display(t.right);
        }
    }

    public void remove(int toRemove) {
        remove(toRemove, this.root);
    }

    private Node remove(int toRemove, Node node){
        if (node == null) ;
        else if (toRemove < node.data){
            node.left = remove(toRemove,node.left);
            node.balance = height(node.right)- height(node.left);
            if (node.balance==2){
                if (node.right.balance!=-1)
                    node=rotateLeft(node);
                else
                    node=doubleRight(node);
            }
            if (node.balance==-2){
                if(node.left.balance!=1)
                    node=rotateRight(node);
                else
                    node=doubleLeft(node);
            }
        }
        else if (toRemove>node.data){
            node.right = remove(toRemove,node.right);
            node.balance = height(node.right) - height(node.left);
            if (node.balance == -2){
                if (node.left.balance!=1)
                    node = rotateRight(node);
                else
                    node = doubleLeft(node);
            }
            if (node.balance == 2){
                if (node.right.balance != -1)
                    node=rotateLeft(node);
                else
                    node=doubleRight(node);
            }
        }
        else if (node.data == toRemove){
            if (node.left == null && node.right == null)
                node = null;
            else if (node.left == null){
                node.right.parent = node.parent;
                node = node.right;
                node.balance = height(node.right) - height(node.left);
                if (node.balance == 2){
                    if (node.right.balance != -1)
                        node = rotateLeft(node);
                    else
                        node = doubleRight(node);
                }
            }
            else if (node.right == null){//if no right kid
                node.left.parent = node.parent;
                node = node.left;
                node.balance = height(node.right) - height(node.left);
                if (node.balance == -2){
                    if (node.left.balance != 1)
                        node = rotateRight(node);
                    else
                        node = doubleLeft(node);
                }
            }
            else{
                node.data = successor(node.right).data;
                node.right = remove(node.data,node.right);
                node.balance = height(node.right)- height(node.left);
                if (node.balance == -2){
                    if (node.left.balance != 1)
                        node = rotateRight(node);
                    else
                        node = doubleLeft(node);
                }
                if (node.balance == 2){
                    if (node.right.balance != -1)
                        node=rotateLeft(node);
                    else
                        node=doubleRight(node);
                }
            }
        }
        return node;
    }

    private Node successor(Node node){
        if(node == null) return null;
        else if(node.left == null)
            return node;
        else
            return successor(node.left);
    }
/*
    public boolean find(int toFind){
        return find(root, toFind);
    }

    private boolean find(Node node,int toFind) {
//       boolean find ;
        if(node == null)
            return false;
        if(node.data>toFind)
                find(node.left,toFind);
        if(node.data<toFind)
                find(node.right, toFind);
        if(node.data==toFind)
            return true;


//        return find;
    }
*/

}
