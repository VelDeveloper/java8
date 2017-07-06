package com.vel.sample.collectors;

import com.vel.sample.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Vadivel
 */
public class CollectorsExample {

    public static void main(String[] args)  {
        
        List<Person> persons = new ArrayList<>();
        System.out.println("current directory::"+System.getProperty("user.dir"));
//        List<String> string = new ArrayList<>();
//        try (Stream<String> stream = Files.lines(Paths.get("people.txt"))) {
//
//            //1. filter line 3
//            //2. convert all content to upper case
//            //3. convert it into a List
//            string = stream
//                    .map(String::toUpperCase)
//                    .collect(Collectors.toList());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        string.forEach(System.out::println);
        try (
//            BufferedReader reader =
//                new BufferedReader(
//                    new InputStreamReader(
//                            CollectorsExample.class.getResourceAsStream("people.txt")));

            Stream<String> stream = Files.lines(Paths.get("people.txt"));
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p;
                    })
                    .forEach(System.out::println);
                
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println(ioe);
        }
        
        Optional<Person> opt = 
        persons.stream().filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println(opt);
        
        Optional<Person> opt2 = 
        persons.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(opt2);
        
        Map<Integer, String> map = 
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge, 
                                Collectors.mapping(
                                        Person::getName, 
                                        Collectors.joining(", ")
                                )
                        )
                );
        System.out.println(map);
        System.out.println("--------------Group by--------------------");
        Map<Integer, List<Person>> mapList =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(Person::getAge)
                                );
        System.out.println(mapList);

        System.out.println("--------------counting--------------------");
        Map<Integer, Long> mapLong =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.counting()
                                        )
                        );
        System.out.println(mapLong);

        System.out.println("--------------collecting as list--------------------");
        Map<Integer, List<String>> mapAsList =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toList()
                                        )
                                )
                        );
        System.out.println(mapAsList);
        System.out.println("--------------collecting as alphabatical order--------------------");
        Map<Integer, Set<String>> mapAsSet =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toCollection(TreeSet::new)
                                        )
                                )
                        );
        System.out.println(mapAsSet);

    }
}
