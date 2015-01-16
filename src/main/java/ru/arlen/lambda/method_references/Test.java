package ru.arlen.lambda.method_references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Reference to a static method --> ContainingClass::staticMethodName
        System.out.println(Test.testPredicate(integerList, x -> Test.isEvenNum(x)));
        System.out.println(Test.testPredicate(integerList, Test::isEvenNum));

        // Reference to a constructor --> ClassName::new
        System.out.println(Test.applyFunc1(integerList, x -> new Double(x)));
        System.out.println(Test.applyFunc1(integerList, Double::new));

        // Reference to an instance method of an arbitrary object of a partucular type --> ContainingType::methodName
        List<Color> colorList = Arrays.asList(new Color("Red"), new Color("Yellow"), new Color("Blue"), new Color("White"));
        System.out.println(Test.applyFunc2(colorList, x -> x.getName()));
        System.out.println(Test.applyFunc2(colorList, Color::getName));

        // Reference to an instance method of a particular object --> ContainingObject::instanceMethodName
        Test.acceptConsumer(integerList, x -> System.out.print(x));
        System.out.println();
        Test.acceptConsumer(integerList, System.out::print);
    }

    public static boolean isEvenNum(Integer x) {
        return (x & 1) == 0;
    }

    public static List<Integer> testPredicate(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> listReturn = new ArrayList<>();
        for (Integer x : list) {
            if (predicate.test(x)) {
                listReturn.add(x);
            }
        }
        return listReturn;
    }

    public static List<Double> applyFunc1(List<Integer> list, Function<Integer, Double> function) {
        List<Double> listReturn = new ArrayList<>();
        list.forEach(x -> listReturn.add(function.apply(x)));
        return listReturn;
    }

    public static List<String> applyFunc2(List<Color> list, Function<Color, String> function) {
        List<String> listReturn = new ArrayList<>();
        list.forEach(x -> listReturn.add(function.apply(x)));
        return listReturn;
    }

    public static void acceptConsumer(List<Integer> list, Consumer<Integer> consumer) {
        list.forEach(x -> consumer.accept(x));
    }
}

class Color {
    private String name;

    Color(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
