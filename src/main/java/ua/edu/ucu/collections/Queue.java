package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Queue {
    private ImmutableList list = new ImmutableLinkedList();

    public Object peek() {
        if (list.isEmpty()) {
            return null;
        }

        return ((ImmutableLinkedList) list).getFirst();
    }

    public Object dequeue() {
        if (list.isEmpty()) {
            return null;
        }

        Object first = ((ImmutableLinkedList) list).getFirst();
        list = ((ImmutableLinkedList) list).removeFirst();

        return first;
    }

    public void enqueue(Object e) {
        list = list.add(e);
    }
}
