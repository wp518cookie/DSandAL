package collection;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ping.wu on 2017/2/22.
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;


    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx), x);
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public AnyType set(int idx, AnyType newVal) {
        Node<AnyType> p = getNode(idx);
        AnyType old = p.data;
        p.data = newVal;
        return old;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
        p.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private AnyType remove(Node<AnyType> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.data;
    }

    private Node<AnyType> getNode(int idx) {
        Node<AnyType> p;
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = theSize; i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public boolean contains(AnyType x) {
        Node<AnyType> t = beginMarker.next;
        while (t != endMarker) {
            if (t.data.equals(x)) {
                return true;
            } else {
                t = t.next;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }

    public void removeAll(Iterable<? extends AnyType> items) {
        Iterator<? extends AnyType> it = items.iterator();
        while (it.hasNext()) {
            Iterator<? extends AnyType> thisIt = this.iterator();
            while (thisIt.hasNext()) {
                if (it.next().equals(thisIt.next())) {
                    thisIt.remove();
                    break;
                }
            }
        }
    }

    //ex3.18
    public void addFirst(AnyType x) {
        addBefore(beginMarker.next, x);
    }

    public void addLast(AnyType x) {
        addBefore(endMarker, x);
    }

    public void removeFirst() {
        remove(beginMarker.next);
    }

    public void removeLast() {
        remove(endMarker.prev);
    }

    public AnyType getFirst() {
        return get(0);
    }

    public AnyType getLast() {
        return get(size() - 1);
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        System.out.println(myLinkedList.contains(2));
        System.out.println(myLinkedList.get(2));
    }
}
