package java17.ex03;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateAndTime_03_Test {

    @Test
    public void test_localTime_of() {
        // Create a LocalTime object at the time 15:24:02
        LocalTime result = LocalTime.of(15, 24, 2);

        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();

        assertThat(hour, is(15));
        assertThat(minutes, is(24));
        assertThat(second, is(2));
    }

    @Test
    public void test_localTime_parse() {
        // Create a LocalTime object at the time 09:30:00 using parse method
        LocalTime result = LocalTime.parse("09:30:00");

        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localTime_format() {
        // Create a LocalTime object at the time 12:00:00 using of method
        LocalTime localTime = LocalTime.of(12, 0, 0);

        // Format the time as "12:00"
        String result = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        assertThat(result, is("12:00"));
    }
}
