package collection.exercise;

import java.util.*;


/**
 * Created by ping.wu on 2017/2/28.
 */
public class ex_3_6 {
    public static void main(String[] args) {
        System.out.println(getWinner(0, 5));
    }

    public static int getWinner(int M, int N) {
        List<Integer> list = new LinkedList();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int idx = M;
        if (idx == 0) {
            return list.get(list.size() - 1);
        }
        Iterator it = list.iterator();
        if (it.hasNext()) {
            it.next();
        }
        while (list.size() > 1) {
            if (idx > 0) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    it = list.iterator();
                    it.next();
                }
                idx--;
            }
            if (idx == 0) {
                it.remove();
                idx = M;
                if (it.hasNext()) {
                    it.next();
                } else {
                    it = list.iterator();
                    it.next();
                }
            }
        }
        return list.get(0);
    }
}
