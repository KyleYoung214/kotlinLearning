package chapter5;

public class JavaMethod {

    public static void postponeComputation(int delay, Runnable runnable) {
        System.out.println("after " + delay + ", run the runnable: " + runnable);
    }
}
