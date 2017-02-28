package collection.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ping.wu on 2017/2/28.
 */
public class ex3_7 {
    public static List<Integer> makeList(int N) {
        ArrayList<Integer> lst = new ArrayList();
        for (int i = 0; i < N; i++) {
            lst.add(i);
            lst.trimToSize();
        }
        return lst;
    }
}
