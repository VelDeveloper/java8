package com.vel.sample.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by vadivel on 06/07/17.
 */
public class FilterMapExample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(2,4,6);
        List<Integer> list3 = Arrays.asList(3,5,7);

        List<List<Integer>> list = Arrays.asList(list1,list2,list3);
        System.out.println(list);

//        list.stream()
//                .map(l -> l.size())
//                .forEach(System.out::println);

        // or

//        Function<List<?>, Integer> size = List::size;
//
//        list.stream()
//                .map(size)
//                .forEach(System.out::println);

        //or

        Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();
        //It will flat the map
        list.stream()
                .flatMap(flatMapper)
                .forEach(System.out::println);
    }
}
