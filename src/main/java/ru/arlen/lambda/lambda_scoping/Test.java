package ru.arlen.lambda.lambda_scoping;

import java.util.function.Consumer;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    int instVal = 2;
    String x = "Hello";
    public static void main(String[] args) {
        Test test = new Test();
        test.go();
    }

    private void go() {
        int locVal = 1;
//        String x = "Hello";
        Consumer<String> consumer = x -> {
//            int locVal = 2;
//            locVal = 2;
            instVal = 3;
            System.out.println("Hare " + x);
        };
        consumer.accept("Krishna!");
        System.out.println("locVal: " + instVal);
    }
}
