package com.sample;

/**
 * Created by locle on 2/27/14.
 */
public class LinkedList {
    protected LinkedListNode head;

    public LinkedList(){
        head = null;
    }

    public void insert(int toAdd){
        head =  insert(toAdd, head);
    }
    private LinkedListNode insert(int toAdd, LinkedListNode head) {
        if(head == null) head = new LinkedListNode(toAdd);
        else if(find(toAdd, head) == false)
            head.next = insert(toAdd, head.next);
        return  head;
    }

    public void display(){
        if(head == null)
            System.out.println("Empty list");
        else display(head);
    }
    private void display(LinkedListNode node){
        if(node != null){
            System.out.println(node.data);
            display(node.next);
        }
    }

    public boolean find(int toAdd){
        return find(toAdd, head);
    }
    private boolean find(int toFind, LinkedListNode node){
        if(node == null) return false;
        else if(node.data == toFind) return true;
        return find(toFind, node.next);
    }

    public void remove(int toRemove){
        remove(toRemove, head);
    }

    private LinkedListNode remove(int toRemove, LinkedListNode node){
        if(node == null) ;
        else if (node.data == toRemove){
            if (node.next == null) //only one node
                head = null;
            else if(node.next != null){
                node = remove(toRemove, node.next);
            }
        }
        return node;
    }
}
