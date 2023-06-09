package com.pratice.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordsInASentence {
    public static void main(String[] args) {
        String sentence = "Kolkata is so humid that everybody is suffering";
        System.out.println(Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .mapToLong(x -> x.getValue()).sum());

        System.out.println(Arrays.stream(sentence.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .count());

        System.out.println(Arrays.asList(sentence).stream().map(String::toUpperCase).collect(Collectors.joining()));

        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 20));

        System.out.println(people.stream()
                                .sorted((p1,p2) -> Integer.compare(p1.getAge(),p2.getAge()))
              //  .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList()));
    }
    static class Person{
        String name;
        int age;

        public Person(String name, int age)
        {
            this.name=name;
            this.age=age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
