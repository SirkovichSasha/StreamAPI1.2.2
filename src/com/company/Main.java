package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = Arrays.asList(
                new Person("Jack", "Evans", 16, Sex.MAN, Education.SECONDARY),
                new Person("Connor", "Young", 23, Sex.MAN, Education.FURTHER),
                new Person("Emily", "Harris", 42, Sex.WOMEN, Education.HIGHER),
                new Person("Harry", "Wilson", 69, Sex.MAN, Education.HIGHER),
                new Person("George", "Davies", 35, Sex.MAN, Education.FURTHER),
                new Person("Samuel", "Adamson", 40, Sex.MAN, Education.HIGHER),
                new Person("John", "Brown", 44, Sex.MAN, Education.HIGHER)
        );

        Stream<Person> stream = persons.stream();
        long count = stream.filter(x -> x.getAge() < 18).count();
        System.out.println("количество несовершеннолетних : " + count);

        Stream<Person> stream2 = persons.stream();
        stream2.filter(x -> x.getAge() > 17 && x.getAge() < 28).map(x -> x.getFamily()).collect(Collectors.toList()).forEach(System.out::println);

        Stream<Person> stream3 = persons.stream();
        stream3.filter(x -> x.getAge() > 17).filter(x -> (x.getAge() < 67 && x.getSex() == Sex.MAN) || (x.getAge() < 61 && x.getSex() == Sex.WOMEN))
                .filter(x -> x.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
