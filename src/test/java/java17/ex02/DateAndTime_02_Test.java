package java17.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.junit.Test;

public class DateAndTime_02_Test {

    @Test
    public void test_localDate_of() {
        // Create a LocalDate object for December 24, 2050
        LocalDate result = LocalDate.of(2050, Month.DECEMBER, 24);

        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();
        DayOfWeek dayOfWeek = result.getDayOfWeek();
        int dayOfYear = result.getDayOfYear();

        assertThat(year, is(2050));
        assertThat(month, is(Month.DECEMBER));
        assertThat(dayOfMonth, is(24));
        assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
        assertThat(dayOfYear, is(358));
    }

    @Test
    public void test_localDate_parse() {
        // Create a LocalDate object for January 10, 1990 using parse method
        LocalDate result = LocalDate.parse("1990-01-10");

        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();

        assertThat(year, is(1990));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(10));
    }

    @Test
    public void test_localDate_format() {
        // Create a LocalDate object for March 11, 2015 using of method
        LocalDate localDate = LocalDate.of(2015, Month.MARCH, 11);

        // Format the date as "11 - 03 - 2015"
        String result = localDate.format(DateTimeFormatter.ofPattern("dd - MM - yyyy"));

        assertThat(result, is("11 - 03 - 2015"));
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void test_localDate_format_with_hour() {
        // Create a LocalDate object for March 11, 2015 using of method
        LocalDate localDate = LocalDate.of(2015, Month.MARCH, 11);

        // Attempt to format the date with hours, which should throw an exception
        localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Test
    public void test_with() {
        // Create a LocalDate object for January 10, 2000 using of method
        LocalDate localDate = LocalDate.of(2000, Month.JANUARY, 10);

        // Transform the date to February 5, 2015
        LocalDate result = localDate.withYear(2015).withMonth(2).withDayOfMonth(5);

        assertThat(result.getYear(), is(2015));
        assertThat(result.getMonth(), is(Month.FEBRUARY));
        assertThat(result.getDayOfMonth(), is(5));
    }
}
