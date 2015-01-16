package ru.arlen.lambda.function_unaryoperator;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(0, 2, 4, 6, 8);
        UnaryOperatorDemo<Integer> unaryOp = new UnaryOperatorDemo<>();
        System.out.println("" + unaryOp.applyFunc(x -> x, integerList));
        System.out.println("" + unaryOp.applyFunc(x -> x * 5, integerList));
        System.out.println("" + unaryOp.applyFuncAndThen(x -> x + x, x -> x * x, integerList));
        System.out.println("" + unaryOp.applyFuncCompose(x -> x + x, x -> x * x, integerList));
    }
}
