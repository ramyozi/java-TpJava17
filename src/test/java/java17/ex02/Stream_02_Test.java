package java17.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Test;

import java17.data.Data;
import java17.data.domain.Customer;
import java17.data.domain.Order;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

    @Test
    public void test_map() throws Exception {

        List<Order> orders = new Data().getOrders();

         List<Customer> result = orders.stream()
                .map(Order::getCustomer)
                .collect(Collectors.toList());

        assertThat(result, hasSize(8));
    }

    @Test
    public void test_map_count() throws Exception {

        List<Order> orders = new Data().getOrders();

         long result = orders.stream()
                .map(Order::getCustomer)
                .count();

        assertThat(result, is(8L));
    }

    @Test
    public void test_map_distinct() throws Exception {

        List<Order> orders = new Data().getOrders();

         List<Customer> result = orders.stream()
                .map(Order::getCustomer)
                .distinct()
                .collect(Collectors.toList());

        assertThat(result, hasSize(2));
    }

    @Test
    public void test_map_distinct_count() throws Exception {

        List<Order> orders = new Data().getOrders();

         long result = orders.stream()
                .map(Order::getCustomer)
                .distinct()
                .count();

        assertThat(result, is(2L));
    }

    @Test
    public void test_mapToDouble_sum() throws Exception {

        List<Order> orders = new Data().getOrders();

        double result = orders.stream()
                .mapToDouble(order -> order.getPizzas().stream()
                        .mapToDouble(pizza -> pizza.getPrice())
                        .sum())
                .sum();

        System.out.println("Total revenue: " + result);

        assertThat(result, is(10900.0));
    }

    @Test
    public void test_mapToDouble_avg() throws Exception {

        List<Order> orders = new Data().getOrders();

        OptionalDouble result = orders.stream()
                .mapToDouble(order -> order.getPizzas().stream()
                        .mapToDouble(pizza -> pizza.getPrice())
                        .average()
                        .orElse(0.0))
                .average();

        if (result.isPresent()) {
            double average = result.getAsDouble();
            System.out.println("Average : " + average);
        } else {
            System.out.println("No orders to calculate average from.");
        }

        assertThat(result.isPresent(), is(true));
        assertThat(result.getAsDouble(), is(1225.0));
    }

}
