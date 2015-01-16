package ru.arlen.stream.collectors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Alexey Galin <arlengur@rambler.ru>
 */
public class Test {
    public static void main(String[] args) {
        List<Person> persons = populatePersons();
        System.out.println("--- use Collectors.toList() in order to obtain the List of US based persons ----");
        List<Person> personList = persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toList());
        System.out.println(personList);
        Map<String, List<Person>> mapOfList = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toList()));
        System.out.println(mapOfList.get("US"));
        System.out.println(mapOfList);
        System.out.println("--- use Collectors.toSet() in order to obtain the Set of US based persons ----");
        System.out.println(persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toSet()));
        Map<String, Set<Person>> mapOfSet = persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toSet()));
        System.out.println(mapOfSet.get("US"));
        System.out.println(mapOfSet);
        System.out.println("--- use Collectors.toCollection(ArrayList::new) in order to obtain the ArrayList of US based persons ----");
        System.out.println(persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toCollection(() -> new ArrayList<Person>())));
        System.out.println(persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(ArrayList::new))));
        System.out.println("--- use Collectors.toCollection(Vector::new) in order to obtain the Vector of US based persons ----");
        System.out.println(persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toCollection(() -> new Vector<Person>())));
        System.out.println(persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(Vector::new))));
        System.out.println("--- use Collectors.toCollection(Stack::new) in order to obtain the Stack of US based persons ----");
        System.out.println(persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toCollection(() -> new Stack<Person>())));
        System.out.println(persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(Stack::new))));
        System.out.println("--- use Collectors.toCollection(HashSet::new) in order to obtain the HashSet of US based persons ----");
        System.out.println(persons.stream().filter(p -> p.getCountry().equals("US")).collect(Collectors.toCollection(() -> new HashSet<Person>())));
        System.out.println(persons.stream().collect(Collectors.groupingBy(p -> p.getCountry(), Collectors.toCollection(HashSet::new))));
    }

    private static List<Person> populatePersons() {
        Person person01 = new Person("JohnA", "US");
        Person person02 = new Person("JohnB", "US");
        Person person03 = new Person("JohnC", "Canada");
        Person person04 = new Person("JohnD", "US");
        Person person05 = new Person("JohnE", "Canada");
        Person person06 = new Person("JohnF", "US");
        Person person07 = new Person("JohnA", "US");
        Person person08 = new Person("JohnE", "Canada");
        List<Person> list = new ArrayList<>();
        list.add(person01);
        list.add(person02);
        list.add(person03);
        list.add(person04);
        list.add(person05);
        list.add(person06);
        list.add(person07);
        list.add(person08);
        return list;
    }
}

class Person {
    private String name;
    private String country;

    Person(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (country != null ? !country.equals(person.country) : person.country != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    String getName() {
        return name;
    }

    String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return getName();
    }
}