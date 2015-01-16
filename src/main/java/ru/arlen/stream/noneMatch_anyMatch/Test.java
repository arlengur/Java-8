package ru.arlen.stream.noneMatch_anyMatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    static int i = 0, j = 0;

    public static void main(String[] args) {
        List<Person> persons = populatePersons();
        persons.stream().forEach(System.out::println);
        System.out.println("\nnoneMatch: returns whether no elements of this stream match the provided predicate.\n");
        System.out.println("noneMatch returned: " +
                persons.stream()
                        .filter(p -> {
                            boolean flag = p.getAge() > 25;
                            System.out.println("[filter 1 age > 25] pass #" + i++ + "| returns:" + flag);
                            return flag;
                        })
                        .noneMatch(p -> {
                            boolean flag = p.getCountry().equals("US");
                            System.out.println("[noneMatch Country='US'] pass #" + j++ + "| returns:" + flag);
                            return flag;
                        })
        );
        i = 0;
        j = 0;
        System.out.println();
        System.out.println("\nanyMatch: returns whether any elements of this stream match the provided predicate.\n");
        System.out.println("anyMatch returned: " +
                persons.stream()
                        .filter(p -> {
                            boolean flag = p.getAge() > 25;
                            System.out.println("[filter 1 age > 25] pass #" + i++ + "| returns:" + flag);
                            return flag;
                        })
                        .anyMatch(p -> {
                            boolean flag = p.getCountry().equals("US");
                            System.out.println("[anyMatch Country='US'] pass #" + j++ + "| returns:" + flag);
                            return flag;
                        })
        );

    }

    private static List<Person> populatePersons() {
        Person person01 = new Person("person01", "US", 20);
        Person person02 = new Person("person02", "Mexico", 25);
        Person person03 = new Person("person03", "US", 26);
        Person person04 = new Person("person04", "US", 29);
        Person person05 = new Person("person05", "Canada", 30);
        List<Person> list = new ArrayList<>();
        list.add(person01);
        list.add(person02);
        list.add(person03);
        list.add(person04);
        list.add(person05);
        return list;
    }
}

class Person {
    private String name;
    private String country;
    private Integer age;

    Person(String name, String country, Integer age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }

    String getName() {
        return name;
    }

    String getCountry() {
        return country;
    }

    Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "(name=" + getName() + ", country=" + getCountry() + ", age=" + getAge() + ")";
    }
}