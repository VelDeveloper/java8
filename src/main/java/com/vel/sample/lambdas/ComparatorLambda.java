package com.vel.sample.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vadivel on 05/07/17.
 */
public class ComparatorLambda {
    public static void main(String... args) {

//        Comparator<String> comp = new Comparator<String>() {
//
//            @Override
//            public int compare(String s1, String s2) {
//
//                return Integer.compare(s1.length(), s2.length());
//            }
//        };

        Comparator<String> compLambda = (String s1, String s2) ->
                Integer.compare(s1.length(), s2.length());

        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, compLambda);

        for(String s : list) {
            System.out.println(s);
        }
    }
}
