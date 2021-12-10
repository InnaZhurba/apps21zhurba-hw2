package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Stack {
    private ImmutableList list = new ImmutableArrayList();

    public void push(Object e) {
        list = list.add(e);
    }

    public Object pop() {
        if (list.isEmpty()) {
            return null;
        }

        Object top = list.get(list.size());
        list = list.remove(list.size());

        return top;
    }

    public Object peek() {
        if (list.isEmpty()) {
            return null;
        }

        return list.get(list.size());
    }
}
