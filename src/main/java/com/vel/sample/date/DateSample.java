package com.vel.sample.date;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * Created by vadivel on 06/07/17.
 */
public class DateSample {
    public static void main(String[] args) {
        //How can i create a date for the 2014/2/10?
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 1, 10); //Here month will start from 0, so for Feb we declared as 1.
        Date feb10th = cal.getTime();

        //How can i add 7 days to feb 10th?
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date oneWeekLater = cal.getTime(); //one week later

        Instant start = Instant.now();
        //some long computations
        Instant end = Instant.now();
        //Now find the duration(amount of time between 2Instances).
        Duration elapsed = Duration.between(start,end);
        long millis = elapsed.toMillis();
        //In java8 they also introduced the concept called local date
        //ex) The dob of shakespeare
        LocalDate now = LocalDate.now();
        LocalDate dob = LocalDate.of(1564, Month.APRIL, 23);
        //Period : It's the amount of time between 2 localDate
        //ex.To find out the amount of time b/w shakespeare born and noe
        Period p = dob.until(now);
        System.out.println("# years = "+p.getYears());

        //To calculate the number of days
        long days = dob.until(now, ChronoUnit.DAYS);
        System.out.println("# days = "+days);
        //DateAdjuster
        //Useful to add (or substract) an amount of time to an instant or a LocalDate
        //Use the method with()
        LocalDate today = LocalDate.now();
        LocalDate nextSunday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        //6) LocalTime
        LocalTime nowTime = LocalTime.now();
        LocalTime bedTime = nowTime.plusHours(8);
        LocalTime time = LocalTime.of(10,20);
        //7) Timezones
        Set<String> allZonesIds = ZoneId.getAvailableZoneIds();
        String ukTZ = ZoneId.of("Europe/London").toString();
        //How to create a zoned time
        System.out.println(
                ZonedDateTime.of(1564, Month.APRIL.getValue(),23, //year/month/day
                        10,0,0,0, //h / mn / s/nanos
                        ZoneId.of("Europe/London")
                )
        );
        ZonedDateTime curerntMeeting = ZonedDateTime.of(1564, Month.APRIL.getValue(),23, //year/month/day
                10,0,0,0, //h / mn / s/nanos
                ZoneId.of("Europe/London")
        );
        ZonedDateTime nextMeeting = curerntMeeting.plus(Period.ofMonths(1));
        //And to change the time zone:
        ZonedDateTime nextMeetingUS = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));
    }
}
