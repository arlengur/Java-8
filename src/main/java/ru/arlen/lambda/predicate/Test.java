package ru.arlen.lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PredicateDemo<Integer> predicateDemo = new PredicateDemo<>();
        System.out.println("Result:     " + predicateDemo.testPredicate(t -> true, integerList));
        System.out.println("Result even:" + predicateDemo.testPredicate(t -> t % 2 == 0, integerList));
        System.out.println("Result odd: " + predicateDemo.testPredicate(t -> t % 2 != 0, integerList));
        System.out.println("-----------------------");
        System.out.println("Result and:     " + predicateDemo.testAndPredicate(t -> t % 2 == 0, t -> t > 5, integerList));
        System.out.println("Result or:  " + predicateDemo.testOrPredicate(t -> t % 2 == 0, t -> t % 2 != 0, integerList));
        System.out.println("Result negate odd: " + predicateDemo.testNegatePredicate(t -> t % 2 != 0, integerList));
    }
}

class PredicateDemo<T> {
    public List<T> testPredicate(Predicate<T> p, List<T> list) {
        List<T> tempList = new ArrayList<>();
        for (T item : list) {
            if (p.test(item)) tempList.add(item);
        }
        return tempList;
    }

    public List<T> testAndPredicate(Predicate<T> p1, Predicate<T> p2, List<T> list) {
        List<T> tempList = new ArrayList<>();
        for (T item : list) {
            if (p1.and(p2).test(item)) tempList.add(item);
        }
        return tempList;
    }

    public List<T> testOrPredicate(Predicate<T> p1, Predicate<T> p2, List<T> list) {
        List<T> tempList = new ArrayList<>();
        for (T item : list) {
            if (p1.or(p2).test(item)) tempList.add(item);
        }
        return tempList;
    }

    public List<T> testNegatePredicate(Predicate<T> p, List<T> list) {
        List<T> tempList = new ArrayList<>();
        for (T item : list) {
            if (p.negate().test(item)) tempList.add(item);
        }
        return tempList;
    }
}