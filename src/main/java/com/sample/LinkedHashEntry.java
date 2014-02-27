package com.sample;

/**
 * Created by locle on 2/26/14.
 */
public class LinkedHashEntry {

    /*
    private int data;
    private LinkedHashEntry next;

    public LinkedHashEntry(){
        this.next = null;
    }

    public  LinkedHashEntry(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedHashEntry getNext() {
        return next;
    }

    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }

    public LinkedHashEntry insert (int toAdd){
        if(this.next == null){
            this.next = new LinkedHashEntry(toAdd);
        }
        else
            this.next.insert(toAdd);
        return this;
    }

    public void display(){
        if(this == null) ;
        else if(this != null && this.next ==null)
            System.out.println(this.data);
        display(this);
    }

    private void display(LinkedHashEntry head){
        while(head.next !=null){
            System.out.println(head.data);
            head = head.next;
        }
    }
    */
    protected LinkedNode head;

    public LinkedHashEntry(){
        head = null;
    }
    public LinkedHashEntry(int toAdd){
        head.data = toAdd;
        head.next = null;
    }

    public void insert(int toAdd){
        if(head == null){
            head = new LinkedNode(toAdd);
        }
        else{
            LinkedNode temp = head;
            head = new LinkedNode(toAdd);
            head.next = temp;
        }
    }
    public void display(){
        if(head == null) return;
        else{
            LinkedNode temp = head;
            while(temp.next != null){
            System.out.println(temp.data);
            temp = temp.next;
            }
        }


    }







}
