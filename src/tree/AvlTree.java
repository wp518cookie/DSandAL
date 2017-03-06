package tree;

/**
 * Created by Administrator on 2017/3/3.
 */
class AvlNode {
    Comparable element;
    AvlNode left;
    AvlNode right;
    int height;
    AvlNode(Comparable theElement) {
        this (theElement, null, null);
    }

    AvlNode(Comparable theElement, AvlNode lt, AvlNode rt) {
        this.element = theElement;
        this.left = lt;
        this.right = rt;
        height = 0;
    }
}

public class AvlTree {
    private AvlNode root;
    public AvlTree() {
        root = null;
    }

    public void insert(Comparable x) {
        root = insert(x, root);
    }

    public void remove(Comparable x) {
        System.out.println("sorry, remove unimplemented");
    }

    public Comparable findMin() {
        return elementAt(findMin(root));
    }

    public Comparable findMax() {
        return elementAt(findMax(root));
    }

    public Comparable find(Comparable x) {
        return elementAt(find(x, root));
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    private Comparable elementAt(AvlNode t) {
        return t == null ? null : t.element;
    }

    private AvlNode insert(Comparable x, AvlNode t) {
        if (t == null) {
            t = new AvlNode(t.element, null, null);
        } else if (x.compareTo(t.element) < 0) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2) {
                if (x.compareTo(t.left.element) < 0) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWIhtLeftChild(t);
                }
            }
        } else if (x.compareTo(t.element) > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2) {
                if (x.compareTo(t.right) > 0) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWihtRightChild(t);
                }
            }
        } else {

        }
        t.height = max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode findMin(AvlNode t) {
        if (t == null) {
            return t;
        }
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private AvlNode findMax(AvlNode t) {
        if (t == null) {
            return t;
        }
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    private AvlNode find(Comparable x, AvlNode t) {
        while (t != null) {
            int compareResult = x.compareTo(t.element);
            if (compareResult < 0) {
                t = t.left;
            } else if (compareResult > 0) {
                t = t.right;
            } else {
                return t;
            }
        }
        return null;
    }

    private void printTree(AvlNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private static int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    private static int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    private static AvlNode rotateWithRightChild(AvlNode k1) {
        AvlNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private static AvlNode rotateWithLeftChild(AvlNode k2) {
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private static AvlNode doubleWIhtLeftChild(AvlNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private static AvlNode doubleWihtRightChild(AvlNode k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
}
