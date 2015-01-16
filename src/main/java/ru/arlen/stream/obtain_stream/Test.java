package ru.arlen.stream.obtain_stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    static List<String> list = populateList();
    static Map<String, String> map = populateMap();

    public static void main(String[] args) {
        System.out.println("-------------obtain stream from list--------------");
        list.stream().forEach(System.out::println);
        System.out.println("-------------obtain stream from map using entrySet()--------------");
        map.entrySet().stream().forEach(System.out::println);
        System.out.println("-------------obtain stream from map using keySet()--------------");
        map.keySet().stream().forEach(System.out::println);
        System.out.println("-------------obtain stream from map using values()--------------");
        map.values().stream().forEach(System.out::println);
        System.out.println("-------------obtain stream from a string using chars()--------------");
        "123456abcdefg".chars().forEach(x -> System.out.println(Character.toChars(x)));
        System.out.println("-------------obtain stream from a string using split()--------------");
        Stream.of("A,B,C,D".split(",")).forEach(System.out::println);
        System.out.println("-------------obtain stream from array--------------");
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream.of(array).forEach(System.out::println);
        System.out.println("-------------obtain Stream of values--------------");
        Stream.of("one", "two", "three").forEach(System.out::println);
        System.out.println("-------------obtain a stream from function generate--------------");
        Stream.generate(() -> {
            return Math.random();
        }).limit(20).forEach(System.out::println);
        System.out.println("-------------obtain a stream from function iterate--------------");
        Stream.iterate(0, i -> i + 1).limit(25).forEach(System.out::println);
        System.out.println("-------------obtain Stream from builder--------------");
        Stream.builder().add("one").add("two").add("three").build().forEach(System.out::println);
        System.out.println("-------------obtain a stream from another stream--------------");
        list.stream().distinct().limit(2).sorted().forEach(System.out::println);
    }

    private static List<String> populateList() {
        List<String> list = new ArrayList<>();
        list.add("listval1");
        list.add("listval2");
        list.add("listval3");
        list.add("listval1");
        list.add("listval2");
        list.add("listval4");
        return list;
    }

    private static Map<String, String> populateMap() {
        Map<String, String> map = new HashMap<>();
        map.put("mapkey1", "mapvalue1");
        map.put("mapkey2", "mapvalue2");
        map.put("mapkey3", "mapvalue3");
        return map;
    }
}


















































