package java17.ex07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Exercice 07 - Instant
 */
public class DateAndTime_07_Test {

    @Test
    public void test_date_to_localdate() throws Exception {
        Date date = createDate(2017, 0, 12); 

        Instant instant = date.toInstant();

        LocalDate result = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        assertThat(result.getYear(), is(2017));
        assertThat(result.getMonth(), is(Month.JANUARY));
        assertThat(result.getDayOfMonth(), is(12));
    }

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
