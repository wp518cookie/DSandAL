package collection.exercise;

/**
 * Created by ping.wu on 2017/2/24.
 */
class DoubleNode {
    DoubleNode prev;
    DoubleNode next;
    private int val;

    public DoubleNode(int val) {
        this.val = val;
    }

    public int val() {
        return val;
    }
}

public class ex3_2_double {
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        print(node1);
        swap_double(node2);
        print(node1);
    }

    public static void swap_double(DoubleNode n) {
        DoubleNode before = n.prev;
        DoubleNode after = n.next;
        before.next = after;
        after.prev = before;
        n.next = after.next;
        after.next = n;
        n.prev = after;
    }

    public static void print(DoubleNode node) {
        while (node != null) {
            System.out.print(node.val());
            node = node.next;
        }
    }
}
