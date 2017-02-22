package test;

/**
 * Created by ping.wu on 2017/2/22.
 */
public interface TestForDefault {
    default void test() {
        System.out.println("hello world");
    }
}
