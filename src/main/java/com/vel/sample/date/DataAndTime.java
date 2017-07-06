package com.vel.sample.date;

import com.vel.sample.model.PersonDate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author José
 */
public class DataAndTime {

    public static void main(String[] args) {

        List<PersonDate> persons = new ArrayList<>();
        
        try (
                Stream<String> stream = Files.lines(Paths.get("peopleDate.txt"));
        ) {
            
            stream.map(
               line -> {
                   String[] s = line.split(" ");
                   String name = s[0].trim();
                   int year = Integer.parseInt(s[1]);
                   Month month = Month.of(Integer.parseInt(s[2]));
                   int day = Integer.parseInt(s[3]);
                   PersonDate p = new PersonDate(name, LocalDate.of(year, month, day));
                   persons.add(p);
                   return p;
               })
               .forEach(System.out::println);
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        LocalDate now = LocalDate.of(2014, Month.MARCH, 12);
        
        persons.stream().forEach(
                p -> {
                    Period period = Period.between(p.getDateOfBirth(), now);
                    System.out.println(p.getName() + " was born " +
                            period.get(ChronoUnit.YEARS) + " years and " + 
                            period.get(ChronoUnit.MONTHS) + " months " + 
                            "[" + p.getDateOfBirth().until(now, ChronoUnit.MONTHS) 
                            + " months]"
                            );
                    
                });
    }
}