package com.vel.sample.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by vadivel on 06/07/17.
 */
public class ReductionExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,10,10);
        //(i1,i2) -> i1+i2 => Integer::sum since sum is a static method.
        Integer red =
        list.stream()
                .reduce(0, Integer::sum);
        //If the list is empty then it will return the identity element.
        //If we pass -10 then it will return 0 since 0 is the identity element it will not go down.
        //To avoid the above condition use Optional
        System.out.println("red = "+red);

        List<Integer> list1 = Arrays.asList(-10,10);
        Optional<Integer> redOptional =
                list1.stream()
                        .reduce(Integer::max);
        //Now it will return the proper value
        System.out.println("Green = "+redOptional.get());
    }
}
