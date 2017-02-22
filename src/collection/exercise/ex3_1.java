package collection.exercise;

import java.util.*;

/**
 * Created by ping.wu on 2017/2/22.
 */
public class ex3_1 {
    public static void main(String[] args) {
        List<Integer> L = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> P = Arrays.asList(1, 3, 5, 7);
        printLots(L, P);
    }

    public static <AnyType> void printLots(List<AnyType> L, List<Integer> P) {
        Iterator<AnyType> itL = L.iterator();
        Iterator<Integer> itP = P.iterator();
        int idx = 0;
        while (itL.hasNext() && itP.hasNext()) {
            if (itP.next() == ++idx) {
                System.out.print(itL.next() + " ");
            } else {
                itL.next();
            }
        }
    }
}
