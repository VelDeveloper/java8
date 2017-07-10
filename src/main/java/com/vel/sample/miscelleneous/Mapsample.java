package com.vel.sample.miscelleneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vadivel on 07/07/17.
 */
public class Mapsample {
    public static void main(String[] args) {
        //From Java8 they have introduced new method in map called
        //getOrDefault => Which will return default value if valus is absent or null
        Map<String,String> map = new HashMap<>();
        map.put("1","one"); //This will override the value if it is already present
        map.putIfAbsent("2","two"); //this will not override the value.
        map.get("1");
        map.getOrDefault("3","Sample"); //If the key is not present then it will return sample.
        map.replace("1","ten"); //This will replace the value for 1.
        //map.replaceAll((key,oldPerson) -> newPerson); //This is the new pne introduced and based on the function it will replace the value.
        //Also introduced new "remove" method.
        map.remove("1","one"); //This will remove the key 1.
        map.remove("2","twoo"); //This will not remove the key 2.Since the value is not same.
        //Also introduced new methods a) compute(),computeIfPresent(),computeIfAbsent(),merge()

    }
}
