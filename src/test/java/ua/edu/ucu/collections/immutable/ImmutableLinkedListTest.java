package ua.edu.ucu.collections.immutable;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableLinkedListTest {
    Integer[] arr = new Integer[]{4,4,2,4,5,6,7,8,3,1};
    ImmutableList list = new ImmutableLinkedList(arr);

    @Test
    public void testToArray() {

        assertArrayEquals(arr, list.toArray());
    }

    @Test
    public void testAdd() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,3,1,5};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        assertArrayEquals(expected.toArray(),list.add(5).toArray());
    }

    @Test
    public void testTestAdd() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,5,3,1};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Object[] actual = list.add(8,5).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testAddAll() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,3,1,5,7,8,9};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Integer[] addToArr = new Integer[]{5,7,8,9};

        Object[] actual = list.addAll(addToArr).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testTestAddAll() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,5,7,8,9,3,1};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Integer[] addToArr = new Integer[]{5,7,8,9};

        Object[] actual = list.addAll(9,addToArr).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testGet() {

        Object actual = list.get(8);
        Assert.assertEquals(8, actual);
    }

    @Test
    public void testRemove() {

        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,3,1};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Object[] actual = list.remove(8).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testSet() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,5,3,1};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Object[] actual = list.set(8,5).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testIndexOf() {
        Assert.assertEquals(4, list.indexOf(5));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(10, list.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testAddFirst() {
        Integer[] newArr = new Integer[]{5,4,4,2,4,5,6,7,8,3,1};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Object[] actual = ((ImmutableLinkedList)list).addFirst(5).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testAddLast() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,3,1,5};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Object[] actual = ((ImmutableLinkedList)list).addLast(5).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testGetHead() {
        Node head = new Node();
        head.setValue(4);

        Assert.assertEquals(head.getValue(), ((ImmutableLinkedList) list).getHead().getValue());
    }

    @Test
    public void testGetTail() {
        Node head = new Node();
        head.setValue(1);

        Assert.assertEquals(head.getValue(), ((ImmutableLinkedList) list).getTail().getValue());

    }

    @Test
    public void testGetFirst() {
        Assert.assertEquals(4, ((ImmutableLinkedList) list).getFirst());
    }

    @Test
    public void testGetLast() {
        Assert.assertEquals(1, ((ImmutableLinkedList) list).getLast());
    }

    @Test
    public void testRemoveFirst() {
        Integer[] newArr = new Integer[]{4,2,4,5,6,7,8,3,1};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Object[] actual = ((ImmutableLinkedList)list).removeFirst().toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testRemoveLast() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,3};
        ImmutableList expected = new ImmutableLinkedList(newArr);

        Object[] actual = ((ImmutableLinkedList)list).removeLast().toArray();
        assertArrayEquals(expected.toArray(),actual);
    }
}