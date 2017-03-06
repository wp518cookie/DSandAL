package tree;

import java.nio.BufferUnderflowException;

/**
 * Created by Administrator on 2017/3/2.
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private BinaryNode<AnyType> root;

    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType x, BinaryNode lt, BinaryNode rt) {
            element = x;
            left = lt;
            right = rt;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {

    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (x == null || t == null) {
            return false;
        }
        if (x.compareTo(t.element) == 0) {
            return true;
        } else if (x.compareTo(t.element) < 0) {
            contains(x, t.left);
        } else {
            contains(x, t.right);
        }
        return false;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {

        }
        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }
}
