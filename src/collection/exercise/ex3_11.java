package collection.exercise;

/**
 * Created by ping.wu on 2017/2/28.
 */
public class ex3_11<AnyType> {
    private Node head;
    private int theSize;

    private class Node<AnyType> {
        private AnyType val;
        public Node next;

        public AnyType val() {
            return val;
        }

        public Node(AnyType val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public ex3_11() {
        theSize = 0;
        head = new Node(null, null);
    }

    public int theSize() {
        return theSize;
    }

    public boolean contains(AnyType x) {
        Node temp = head.next;
        while (temp != null) {
            if (temp.equals(x)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public void remove(AnyType x) {
        Node temp = head.next;
        Node pre = head;
        while (temp != null) {
            if (temp.equals(x)) {
                pre.next = temp.next;
            }
            temp = temp.next;
            pre = pre.next;
        }
    }
}
