package collection.exercise;

import java.util.List;

/**
 * Created by ping.wu on 2017/2/28.
 */
public class ex3_8 {
    public static void removeFirstHalf(List<?> lst) {
        int theSize = lst.size() / 2;
        for (int i = 0; i < theSize; i++) {
            lst.remove(i);
        }
    }
}
