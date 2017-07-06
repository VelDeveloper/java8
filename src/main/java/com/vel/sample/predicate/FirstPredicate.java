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

    }
}
