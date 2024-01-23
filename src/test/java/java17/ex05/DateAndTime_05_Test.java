package java17.ex05;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DateAndTime_05_Test {

    @Test
    public void test_duration() throws Exception {
        LocalTime time1 = LocalTime.of(12, 30);
        LocalTime time2 = LocalTime.of(16, 32);
        Duration duration = Duration.between(time1, time2);

        assertThat(duration.toMinutes(), is(242L));
        assertThat(duration.toHours(), is(4L));
        assertThat(duration.toNanos(), is(14_520_000_000_000L));
        assertThat(duration.toMillis(), is(14_520_000L));
        assertThat(duration.toDays(), is(0L));
    }
}
