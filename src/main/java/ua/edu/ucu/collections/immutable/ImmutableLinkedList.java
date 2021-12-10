package ua.edu.ucu.collections.immutable;


public final class ImmutableLinkedList implements ImmutableList {

    private Node head;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        length = 0;
        for (Object element : elements) {
            addToEnd(element);
        }
    }

    public ImmutableLinkedList() {
        head = null;
        length = 0;
    }
    private void addToEnd(Object e) {
        Node newNode = new Node();
        newNode.setValue(e);

        Node last = head;
        newNode.setNext(null);

        length++;
        if (head == null) {
            newNode.setPrevious(null);
            head = newNode;
            return;
        }

        while (last.getNext() != null) {
            last = last.getNext();
        }

        last.setNext(newNode);

        newNode.setPrevious(last);
    }
    @Override
    public ImmutableList add(Object e) {
        addToEnd(e);

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Node prevNode = head;

        for (int i = 0; i < length; i++) {

            if (index - 1 <= 0) {
                return null;
            }

            if (i == index - 1) {

                if (prevNode == null) {
                    break;
                }

                Node newNode = new Node();
                newNode.setValue(e);

                newNode.setNext(prevNode.getNext());

                prevNode.setNext(newNode);

                newNode.setPrevious(prevNode);

                if (newNode.getNext() != null) {
                    newNode.getNext().setPrevious(newNode);
                }
                length++;
            }
            prevNode = prevNode.getNext();
        }

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public ImmutableList addAll(Object[] c) {

        for (Object o : c) {
            addToEnd(o);
        }

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {

        for (int i = index - 1, j = 0; i < index - 1 + c.length; i++, j++) {
            add(i, c[j]);
        }

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public Object get(int index) {

        Node template = head;

        for (int i = 0; i < length; i++) {

            if (i == index - 1) {
                return template.getValue();
            }

            template = template.getNext();
        }

        return null;
    }

    @Override
    public ImmutableList remove(int index) {

        Node template = head;

        for (int i = 0; i < length; i++) {

            if (i == index - 1) {
                if (template == null) {
                    break;
                }

                if (head == template) {
                    head = template.getNext();
                }

                if (template.getNext() != null) {
                    template.getNext().setPrevious(template.getPrevious());
                }

                if (template.getPrevious() != null) {
                    template.getPrevious().setNext(template.getNext());
                }
                length--;
                break;
            }
            template = template.getNext();
        }

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public ImmutableList set(int index, Object e) {

        remove(index);
        add(index-1, e);

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public int indexOf(Object e) {

        Node template = head;

        for (int i = 0; i < length; i++) {
            if (template.getValue() == e) {
                return i;
            }
            template = template.getNext();
        }

        return 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length <= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[length];
        Node tmp = head;
        for (int i = 0; i < length; i++) {
            newArr[i] = tmp.getValue();
            tmp = tmp.getNext();
        }
        return newArr;
    }

    public ImmutableLinkedList addFirst(Object e) {

        Node newNode = new Node();
        newNode.setValue(e);

        newNode.setNext(head);
        newNode.setPrevious(null);

        if (head != null) {
            head.setPrevious(newNode);
        }

        head = newNode;
        length++;

        return new ImmutableLinkedList(toArray());
    }

    public ImmutableLinkedList addLast(Object e) {
        addToEnd(e);

        return new ImmutableLinkedList(toArray());
    }

    public Node getHead() {

        return head;
    }

    public Node getTail() {
        Node tail = head;

        for (int i = 0; i < length-1; i++) {
            tail = tail.getNext();
        }

        return tail;
    }

    public Object getFirst() {

        return get(1);
    }

    public Object getLast() {

        return get(length);
    }

    public ImmutableLinkedList removeFirst() {

        return ((ImmutableLinkedList) remove(1));
    }

    public ImmutableLinkedList removeLast() {

        return ((ImmutableLinkedList) remove(length));
    }
}
