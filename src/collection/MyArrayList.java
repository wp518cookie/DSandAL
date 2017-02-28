package collection;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by ping.wu on 2017/2/22.
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    public AnyType remove(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }
        AnyType removedItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theItems[size() - 1] = null;
        theSize--;
        return removedItem;
    }

    public Iterator iterator() {
        return new ArrayListIterator();
    }

    //ex3.13
    public ListIterator listIterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements ListIterator<AnyType> {
        private int current = 0;
        boolean backwards = false;

        //belongs listIterator -----------------------------------------
        @Override
        public void set(AnyType x) {
            theItems[current] = x;
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public AnyType previous() {
            if (!hasPrevious()) {
                throw new java.util.NoSuchElementException();
            }
            backwards = true;
            return theItems[--current];
        }

        @Override
        public void add(AnyType x) {
            MyArrayList.this.add(current++, x);
        }


        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current < theSize;
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        //ex3.9
        public void addAll(Iterable<? extends AnyType> items) {
            Iterator<? extends AnyType> it = items.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }
    //ex3.16
    public Iterator reverseIterator() {
        return new ArrayListReverseIterator();
    }

    private class ArrayListReverseIterator implements Iterator<AnyType> {
        private int index = MyArrayList.this.theSize - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public AnyType next() {
            return theItems[index--];
        }
    }
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator it = list.reverseIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}