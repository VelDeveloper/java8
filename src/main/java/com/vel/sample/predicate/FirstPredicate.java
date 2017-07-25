package com.vel.sample.predicate;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by vadivel on 06/07/17.
 */
public class FirstPredicate
{
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one","two","three","four","five");
        //stream.forEach(s -> System.out.println(s));
        //stream.forEach(System.out::println);
        System.out.println("---------");
        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");
//        stream.filter(p1)
//                .forEach(System.out::println);
        stream.filter(p2.or(p3))
                .forEach(System.out::println);
        Predicate<String> p = s -> s.length() < 20;
        Predicate<String> p4 = s -> s.length() > 5;
        Predicate<String> p5 = p.and(p4);
        Predicate<String> p6 = p.or(p4);
        boolean b = p.test("Hello");
        System.out.println("Hello is shorter than 20chars:"+b);
        System.out.println("Good Morning is shorter than 20chars:"+p5.test("Good Morning"));
        System.out.println("Yes is shorter than 20chars:"+p5.test("Yes"));
        System.out.println("Good Morning is shorter than 20chars:"+p5.test("Good Morning vadivel murugan"));
        System.out.println("Good Morning is shorter than 20chars:"+p6.test("Good Morning vadivel murugan"));

        Predicate<String> p7 = Predicate.isEqual("Yes");
        System.out.println("Equal:"+p7.test("Yes"));
        System.out.println("Not Equal:"+p7.test("Yes!!"));

    }
}
