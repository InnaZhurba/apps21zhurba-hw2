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
        Node new_node = new Node();
        new_node.setValue(e);

        Node last = head;
        new_node.setNext(null);

        length++;
        if (head == null) {
            new_node.setPrevious(null);
            head = new_node;
            return;
        }

        while (last.getNext() != null) {
            last = last.getNext();
        }

        last.setNext(new_node);

        new_node.setPrevious(last);
    }
    @Override
    public ImmutableList add(Object e) {
        addToEnd(e);

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Node prev_Node = head;

        for (int i = 0; i < length; i++) {

            if (index - 1 <= 0) {
                index = 1;
            }

            if (i == index - 1) {

                if (prev_Node == null) {
                    break;
                }

                Node new_node = new Node();
                new_node.setValue(e);

                new_node.setNext(prev_Node.getNext());

                prev_Node.setNext(new_node);

                new_node.setPrevious(prev_Node);

                if (new_node.getNext() != null) {
                    new_node.getNext().setPrevious(new_node);
                }
                length++;
            }
            prev_Node = prev_Node.getNext();
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

        for (int i = index-1, j = 0; i < index - 1 + c.length; i++, j++) {
            add(i,c[j]);
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
        add(index-1,e);

        return new ImmutableLinkedList(toArray());
    }

    @Override
    public int indexOf(Object e) {

        Node template = head;

        for (int i = 0; i < length; i++) {
            if(template.getValue() == e) {
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
        return length<=0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[length];
        Node tmp = head;
        for(int i=0;i<length;i++){
            newArr[i]=tmp.getValue();
            tmp=tmp.getNext();
        }
        return newArr;
    }

    public ImmutableLinkedList addFirst(Object e) {

        Node new_Node = new Node();
        new_Node.setValue(e);

        new_Node.setNext(head);
        new_Node.setPrevious(null);

        if (head != null)
            head.setPrevious(new_Node);

        head = new_Node;
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

        return ((ImmutableLinkedList)remove(1));
    }

    public ImmutableLinkedList removeLast() {

        return ((ImmutableLinkedList)remove(length));
    }
}
