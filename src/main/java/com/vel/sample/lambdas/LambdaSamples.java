package com.vel.sample.lambdas;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Created by vadivel on 04/07/17.
 */
public class LambdaSamples {

    //What is lambda exp? => It's just another way of writing instances of anonymous classes.
    public static void main(String[] args) {
        System.out.println("Java8 samples");
        Consumer<String> c = s -> System.out.print("sample");
        System.out.println("print string "+c);

        Comparator<Integer> compareInteger = (i1, i2) -> Integer.compare(i1,i2);
        Comparator<Integer> compareIntegers = Integer::compare;

    }
}
