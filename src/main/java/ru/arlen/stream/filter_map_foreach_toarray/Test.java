package ru.arlen.stream.filter_map_foreach_toarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        List<Person> persons = populatePersons();
        System.out.println("--- Ids of all persons from the US (using filter, map and forEach methods) ----");
        persons.stream()
                .filter(p -> p.getCountry().equals("US"))
                .map((Person person) -> "id: " + person.getId() + ", country: " + person.getCountry())
                .forEach(System.out::println);
        System.out.println("--- Ids of all persons not from the US (using filter, map and forEach methods) ----");
        persons.stream()
                .filter(p -> !p.getCountry().equals("US"))
                .map((Person person) -> "id: " + person.getId() + ", country: " + person.getCountry())
                .forEach(System.out::println);
        System.out.println("--- using <A> [A] toArray(IntFunction<A[]> generator) method ----");
        Person[] personsArray = persons.stream().toArray(Person[]::new);
        Arrays.asList(personsArray).forEach(System.out::println);
        System.out.println("--- using Object[] toArray() method ----");
        Object[] objectsArray = persons.stream().toArray();
        Arrays.asList(objectsArray).forEach(o -> System.out.println(((Person) o).getId()));
    }

    private static List<Person> populatePersons() {
        Person person01 = new Person("person01", "US");
        Person person02 = new Person("person02", "Mexico");
        Person person03 = new Person("person03", "Canada");
        Person person04 = new Person("person04", "US");
        List<Person> list = new ArrayList<>();
        list.add(person01);
        list.add(person02);
        list.add(person03);
        list.add(person04);

        return list;
    }
}

class Person {
    private String id;
    private String country;

    Person(String id, String country) {
        this.id = id;
        this.country = country;
    }

    String getId() {
        return id;
    }

    String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return getId();
    }
}