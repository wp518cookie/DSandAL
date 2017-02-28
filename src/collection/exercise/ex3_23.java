package collection.exercise;

import java.util.Stack;

/**
 * Created by ping.wu on 2017/2/28.
 */
public class ex3_23 {
    public static void main(String[] args) {
        String x = "(3 + 4) × 5 - 6 ";
        reverseHeadToBack(x);
    }

    public static String reverseHeadToBack(String s) {
        Stack<Double> stack = new Stack();
        Double a, b, result;
        for (int i = 0; i < s.length(); i++) {
            boolean isNumber = true;
            try {
                Double t = Double.valueOf(String.valueOf(s.charAt(i)));
            } catch (Exception e) {
                isNumber = false;
            }
        }
        return null;
    }
}
