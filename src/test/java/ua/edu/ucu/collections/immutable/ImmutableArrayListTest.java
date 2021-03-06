package ua.edu.ucu.collections.immutable;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;

public class ImmutableArrayListTest {

    Integer[] arr = new Integer[]{4,4,2,4,5,6,7,8,3,1};
    ImmutableList list = new ImmutableArrayList(arr);

    @Test
    public void testToArray() {

        assertArrayEquals(arr, list.toArray());
    }

    @Test
    public void testAdd() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,3,1,5};
        ImmutableList expected = new ImmutableArrayList(newArr);

        assertArrayEquals(expected.toArray(),list.add(5).toArray());
    }

    @Test
    public void testTestAdd() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,5,8,3,1};
        ImmutableList expected = new ImmutableArrayList(newArr);

        Object[] actual = list.add(8,5).toArray();
        Object[] expectedRes = expected.toArray();
        assertArrayEquals(expectedRes,actual);
    }

    @Test
    public void testAddAll() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,3,1,5,7,8,9};
        ImmutableList expected = new ImmutableArrayList(newArr);

        Integer[] addToArr = new Integer[]{5,7,8,9};

        Object[] actual = list.addAll(addToArr).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testTestAddAll() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,8,5,7,8,9,3,1};
        ImmutableList expected = new ImmutableArrayList(newArr);

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
        ImmutableList expected = new ImmutableArrayList(newArr);

        Object[] actual = list.remove(8).toArray();
        assertArrayEquals(expected.toArray(),actual);
    }

    @Test
    public void testSet() {
        Integer[] newArr = new Integer[]{4,4,2,4,5,6,7,5,3,1};
        ImmutableList expected = new ImmutableArrayList(newArr);

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
}