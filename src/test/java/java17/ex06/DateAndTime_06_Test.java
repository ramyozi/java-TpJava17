package java17.ex06;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DateAndTime_06_Test {

    @Test
    public void test_period() throws Exception {
        LocalDate localDate1 = LocalDate.of(2017, 12, 31);
        LocalDate localDate2 = LocalDate.of(2050, 1, 1);
        Period result = Period.between(localDate1, localDate2);

        assertThat(result.toTotalMonths(), is(384L));
    }
}
