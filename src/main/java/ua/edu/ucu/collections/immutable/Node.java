package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node() {
        previous=null;
        next=null;
        value = null;
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node prev) {
        previous=prev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object val) {
        value=val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nxt) {//Node ne
        next=nxt;
    }
}

