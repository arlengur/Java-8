package ru.arlen.lambda.function;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(0, 2, 4, 6, 8);
        FunctionDemo<Integer, Double> functionDemo = new FunctionDemo();
        System.out.println("" + functionDemo.applyFunc(x -> new Double(x), integerList));
        System.out.println("" + functionDemo.applyFunc(x -> new Double(x * 0.5), integerList));
        System.out.println("" + functionDemo.applyFuncAndThen(x -> new Double(x), x -> x + x, integerList));
        System.out.println("" + functionDemo.applyFuncCompose(x -> new Double(x) + 1, x -> new Double(x) + new Double(x), integerList));
    }
}
