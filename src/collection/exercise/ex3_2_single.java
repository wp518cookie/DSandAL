package collection.exercise;

/**
 * Created by ping.wu on 2017/2/24.
 * 单链表交换
 */
class SingleNode {
    SingleNode next;
    private int val;

    public SingleNode(int val) {
        this.val = val;
    }

    public int val() {
        return val;
    }
}

public class ex3_2_single {
    public static void swap_single(SingleNode beforeNode) {
        SingleNode p, afterP;
        p = beforeNode.next;
        afterP = p.next;
        beforeNode.next = afterP;
        p.next = afterP.next;
        afterP.next = p;
    }

    public static void main(String[] args) {
        SingleNode node1 = new SingleNode(1);
        SingleNode node2 = new SingleNode(2);
        SingleNode node3 = new SingleNode(3);
        node1.next = node2;
        node2.next = node3;
        print(node1);
        swap_single(node1);
        print(node1);
    }

    public static void print(SingleNode s) {
        while (s != null) {
            System.out.print(s.val() + " ");
            s = s.next;
        }
    }
}
