package ua.edu.ucu.collections.immutable;
import static java.lang.System.arraycopy;

public final class ImmutableArrayList implements ImmutableList {
    private Node[] list = new Node[1];
    private int length;
    private int currentSize;

    public ImmutableArrayList(Object[] elements) {
        length = list.length;
        currentSize = 0;
        //list = new Node[elements.length];
        for (Object element : elements) {
            addToEnd(element);
        }
    }

    public ImmutableArrayList() {

        list = new Node[length+1];
    }
    private void addToEnd(Object e) {

        if (currentSize >= length) {
            resizeArray();
        }

        list[currentSize] = new Node();
        list[currentSize].setValue(e);
        currentSize++;
}
    @Override
    public ImmutableList add(Object e) {
        addToEnd(e);

        return new ImmutableArrayList(toArray());
    }

    @Override
    public ImmutableList add(int index, Object e) {

        Object[] listArr = toArray();

        return new ImmutableArrayList(addElementByInd(index, e, listArr));
    }
    private Object[] addElementByInd(int index, Object e, Object[] listArr) {

        Object[] newArr = new Object[listArr.length+1];

        arraycopy(listArr, 0, newArr, 0, index-1);
        newArr[index-1] = e;

        for (int i = index, j = index - 1; j < listArr.length; i++, j++) {
            newArr[i] = listArr[j];
        }

        return newArr;
    }

    @Override
    public ImmutableList addAll(Object[] c) {

        for (Object o : c) {
            addToEnd(o);
        }

        return new ImmutableArrayList(toArray());
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {

        Object[] listArr = toArray();

        for (int i = index, j = 0; i < index + c.length; i++, j++) {
            listArr = addElementByInd(i, c[j], listArr);//add(i,c[j]);
        }

        return new ImmutableArrayList(listArr);
    }

    @Override
    public Object get(int index) {

         if (index <= currentSize) {
             return list[index - 1].getValue();
         }

        return null;
    }

    @Override
    public ImmutableList remove(int index) {

        if (index > currentSize) {
            return null;
        }

        Object[] listArr = toArray();

        return new ImmutableArrayList(removeFromArr(index, listArr));
    }
    private Object[] removeFromArr(int index, Object[] listArr) {

        Object[] newArr = new Object[length - 1] ;
        arraycopy(listArr,0, newArr,0, index-1);

        for (int i = index-1, j = index; j < listArr.length; i++, j++) {
            newArr[i] = listArr[j];
        }

        return newArr;
    }

    @Override
    public ImmutableList set(int index, Object e) {

        Object[] newArr = toArray();
        newArr = removeFromArr(index, newArr);
        newArr = addElementByInd(index, e, newArr);

        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {

        for (int i = 0; i < length; i++) {
            if (list[i].getValue() == e) {
                return i;
            }
        }

        return 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return currentSize <= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[length] ;

        for (int i = 0; i < currentSize; i++) {
            newArr[i] = list[i].getValue();
        }

        return newArr;
    }

    private void resizeArray(){
        length = length+1;
        Node[] newArr = new Node[length];

        arraycopy(list, 0, newArr, 0, list.length);

        list = newArr;
    }
}
