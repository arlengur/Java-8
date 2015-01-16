package ru.arlen.stream.allmatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    static int i = 0, j = 0, k = 0;

    public static void main(String[] args) {
        List<Person> persons = populatePersons();
        persons.stream().forEach(System.out::println);
        System.out.println("\nallMatch: returns whether all elements of this stream match the provided predicate.\n");
        System.out.println("allMatch returned: " +
                persons.stream()
                        .allMatch(p -> {
                            boolean flag = p.getCountry().equals("US");
                            System.out.println("[allMatch Country='US'] pass " + i++ + "| returns:" + flag);
                            return flag;
                        })
        );
        System.out.println();
        i = 0;
        System.out.println("allMatch returned: " +
                persons.stream()
                        .filter(p -> {
                            boolean flag = p.getAge() > 25;
                            System.out.println("[filter 1 age > 25] pass #" + i++ + "| returns:" + flag);
                            return flag;
                        })
                        .allMatch(p -> {
                            boolean flag = p.getCountry().equals("US");
                            System.out.println("[allMatch Country='US'] pass #" + j++ + "| returns:" + flag);
                            return flag;
                        })
        );
        System.out.println();
        i = 0;
        j = 0;
        System.out.println("allMatch returned: " +
                persons.stream()
                        .filter(p -> {
                            boolean flag = p.getAge() > 25;
                            System.out.println("[filter 1 age > 25] pass #" + i++ + "| returns:" + flag);
                            return flag;
                        })
                        .filter(p -> {
                            boolean flag = p.getWeight() > 90;
                            System.out.println("[filter 1 weight > 90] pass #" + j++ + "| returns:" + flag);
                            return flag;
                        })
                        .allMatch(p -> {
                            boolean flag = p.getCountry().equals("US");
                            System.out.println("[allMatch Country='US'] pass #" + k++ + "| returns:" + flag);
                            return flag;
                        })
        );
    }

    private static List<Person> populatePersons() {
        Person person01 = new Person("person01", "US", 20, 87);
        Person person02 = new Person("person02", "Mexico", 25, 90);
        Person person03 = new Person("person03", "US", 26, 110);
        Person person04 = new Person("person04", "US", 29, 120);
//        Person person04 = new Person("person04", "Canada", 29, 120);
        Person person05 = new Person("person05", "US", 30, 97);
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
    private Integer weight;

    Person(String name, String country, Integer age, Integer weight) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.weight = weight;
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

    Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(name=" + getName() + ", country=" + getCountry() + ", age=" + getAge() + ", weight=" + getWeight() + ")";
    }
}