package com.vel.sample.string;

import java.util.StringJoiner;

/**
 * Created by vadivel on 06/07/17.
 */
public class AppendIssue {
    public static void main(String[] args) {
        //Using string we can concat string but we will face memory issues
        //instead we can use StringBuffer which will resolve the issue but it is sync
        //Instead we can use StringBuilder even though it is async we will face some issues in multi threaded env.
        //So in Java-8 they have introduced a handy solution for that
        StringJoiner sj = new StringJoiner(", ");
        sj.add("one").add("two").add("three");
        //Java8 way
        StringJoiner sj1 = new StringJoiner(", ", "{", "}");
        System.out.println(sj1.toString());
        sj1.add("one");
        System.out.println(sj1.toString());
        sj1.add("two");
        System.out.println(sj1.toString());

        //From String class with vararg
        String s = String.join(", ", "one", "two", "three");
        System.out.println(s);

        String[] tab = {"one", "two", "three"};
        String s1 = String.join(", ",tab);
        System.out.println(s1);

    }
}
