package prioritydeque;

/**
 * Created by Administrator on 2017/3/3.
 */
public class BinaryHeap {
    private Comparable[] array;
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 10;
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new Comparable[capacity + 1];
    }

    public void insert(Comparable x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        int hole = ++currentSize;
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
    }

    public Comparable findMin() {
        if (isEmpty()) {
            return null;
        }
        return array[1];
    }

    public Comparable deleteMin() {
        if (isEmpty()) {
            return null;
        }
        Comparable minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private void percolateDown(int hole) {
        int child;
        Comparable temp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(temp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = temp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize) {

    }
}
