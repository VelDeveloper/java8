package com.vel.sample.comparator;

import com.vel.sample.model.Person;

import java.util.Comparator;

/**
 * Created by vadivel on 07/07/17.
 */
public class SampleComparator {
    public static void main(String[] args) {
        Comparator<Person> sampleCompare = (p1,p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> sampleCompareByName = (p1,p2) -> p2.getName().compareTo(p1.getName());
        //The above can be written like
        Comparator<Person> comparatorage = Comparator.comparing(p -> p.getAge());
        //or
        Comparator<Person> comparatorName = Comparator.comparing(Person::getName);
        Comparator<Person> comp = comparatorage.thenComparing(comparatorName);
        //or multiple operation
        Comparator<Person> comparatorMultiple = Comparator.comparing(Person::getAge)
                .thenComparing(Person::getName);
        //we can also compare the result
        Comparator<Person> comparatorNameCompare = Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge);
        //How to reverse a comparator.
        Comparator<Person> reverseComp = comparatorName.reversed();
        //compares comparable object which is normal.
        Comparator<String> c = Comparator.naturalOrder();
        //Consider null values lesser than non-null values
        Comparator<String> d = Comparator.nullsFirst(Comparator.naturalOrder());
        //Consider null values at last
        Comparator<String> e = Comparator.nullsLast(Comparator.naturalOrder());

    }
}
