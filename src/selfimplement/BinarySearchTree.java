package selfimplement;

/**
 * Created by Administrator on 2017/3/6.
 */
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>> {
    private BinaryNode<AnyType> root;

    private static class BinaryNode<AnyType> {
        private AnyType element;
        private BinaryNode<AnyType> left;
        private BinaryNode<AnyType> right;

        public BinaryNode(AnyType element) {
            this(element, null, null);
        }

        public BinaryNode(AnyType element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
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
        if (root == null) {
            return false;
        }
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
        insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {

    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return false;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            return contains(x, t.right);
        } else if (compareResult < 0) {
            return contains(x, t.left);
        } else {
            return true;
        }
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null) {
            return t;
        }
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
            t.element = findMax(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left == null) ? t.right : t.left;
        }
        return t;
    }
}
