package java17.ex01;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateAndTime_01_Test {

    @Test
    public void test_date() {
        LocalDate localDate = LocalDate.of(2017, Month.MARCH, 24);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertThat(date.toString(), is("Fri Mar 24 00:00:00 CET 2017"));

        localDate = localDate.plusDays(1);
        date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertThat(date.toString(), is("Sat Mar 25 00:00:00 CET 2017"));
    }

    @Test
    public void test_calendar() throws Exception {
        LocalDate localDate = LocalDate.of(2017, Month.MARCH, 24);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        assertThat(date.toString(), is("Fri Mar 24 00:00:00 CET 2017"));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, 1);

        assertThat(calendar.getTime().toString(), is("Sat Mar 25 00:00:00 CET 2017"));
    }
}
