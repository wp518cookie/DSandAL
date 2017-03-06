package selfimplement;

/**
 * Created by Administrator on 2017/3/6.
 */
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>> {
    private BinaryNode<AnyType> root;

    private static class BinaryNode<AnyType> {

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

    }

    public AnyType findMin() {

    }

    public AnyType findMax() {

    }

    
}
