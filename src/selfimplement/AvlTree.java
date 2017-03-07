package selfimplement;

/**
 * Created by Administrator on 2017/3/7.
 */
class AvlNode {
    private Comparable element;
    private AvlNode left;
    private AvlNode right;
    int height;

    public AvlNode(Comparable element) {
        this(element, null, null);
    }
    public AvlNode(Comparable element, AvlNode left, AvlNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
public class AvlTree {
    private AvlNode root;
    public AvlTree() {
        root = null;
    }

    public void insert() {

    }

    public void remove() {

    }

    public Comparable findMin() {

    }

    public Comparable findMax() {

    }

    public Comparable find(Comparable x) {

    }

    public void makeEmpty() {

    }

    public boolean isEmpty() {

    }

    public void printTree() {

    }

    private Comparable elementAt(AvlNode t) {

    }

    private AvlNode insert(Comparable x, AvlNode t) {

    }

    private AvlNode find(Comparable x, AvlNode t) {

    }

    private AvlNode findMin(AvlNode t) {

    }

    private AvlNode findMax(AvlNode t) {

    }

    private AvlNode find(Comparable x, AvlNode t) {

    }

    private int height(AvlNode t) {

    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private AvlNode rotateWithRightChild(AvlNode t) {

    }

    private AvlNode rotateWihtLeftChild(AvlNode t) {

    }

    private AvlNode doubleWithLeftChild(AvlNode t) {

    }

    private AvlNode doubleWithRightChild(AvlNode t) {

    }
}
