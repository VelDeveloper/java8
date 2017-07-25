package com.vel.sample.collectors;

import com.vel.sample.model.City;
import com.vel.sample.model.Person;

import java.util.*;

/**
 * Created by vadivel on 25/07/17.
 */
public class IterableExample {

    public static void main(String[] args) {
        Person p1 = new Person("Vadivel",29);
        Person p2 = new Person("Nagaraj",25);
        Person p3 = new Person("Venkatesh",33);
        Person p4 = new Person("Dinesh",28);
        Person p5 = new Person("Parthiban",26);
        Person p6 = new Person("Raja",28);
        List<Person> personList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));
        personList.forEach(person -> System.out.println(person));
        //or
        System.out.println("-----------------------");
        personList.removeIf(person ->  person.getAge() < 26);
        personList.replaceAll(person -> new Person(person.getName().toUpperCase(),person.getAge()));
        personList.sort(Comparator.comparing(Person::getAge));
        personList.forEach(System.out::println);

        System.out.println("----------Reverse the list and print--------------");
        personList.sort(Comparator.comparing(Person::getAge).reversed());
        personList.forEach(System.out::println);

        City newyork = new City("New york");
        City munich  = new City("Munich");
        City paris   = new City("Paris");

        Map<City,List<Person>> map = new HashMap<>();
        System.out.println("People's from paris::"+map.getOrDefault(paris,Collections.EMPTY_LIST));

        map.putIfAbsent(paris,new ArrayList<>());
        map.get(paris).add(p1);

        map.computeIfAbsent(newyork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(newyork, city -> new ArrayList<>()).add(p3);

        System.out.println("People's from paris::"+map.getOrDefault(paris,Collections.EMPTY_LIST));
        System.out.println("People's from newyork::"+map.getOrDefault(newyork,Collections.EMPTY_LIST));
    }
}
