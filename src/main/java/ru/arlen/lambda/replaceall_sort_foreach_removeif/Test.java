package ru.arlen.lambda.replaceall_sort_foreach_removeif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("0/ original list of Integers: " + integerList);

        integerList.replaceAll(x -> x * 5);
        System.out.println("1/ multiply all Integers by 5: " + integerList);

        integerList.sort((x0, x1) -> x1.intValue() - x0.intValue());
        System.out.println("2/ sort Integers in descending order: " + integerList);

        List<Double> doubleList = new ArrayList<>();
        Function<Integer, Double> function = x -> x.doubleValue();
        integerList.forEach(x -> doubleList.add(function.apply(x)));
        System.out.println("3/ turn Integers into Double: " + doubleList);

        doubleList.removeIf(x -> x.intValue() > 20);
        System.out.println("4/ remove all Double > 20: " + doubleList);
    }
}