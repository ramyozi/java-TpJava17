package java17.ex01;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import java17.data.Data;
import java17.data.domain.Order;
import java17.data.domain.Pizza;

/**
 * Exercice 01 - Recherche
 */
public class Stream_01_Test {

	@Test
	public void test_stream_filter() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		List<Pizza> expensivePizzas = pizzas.stream()
				.filter(pizza -> pizza.getPrice() >= 1300)
				.collect(Collectors.toList());

		System.out.println("Pizzas dont le prix est >= 1300 :");
		expensivePizzas
				.forEach(pizza -> System.out.println(pizza.getName()));
	}

	@Test
	public void test_stream_filter_collect_counting() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		long result = pizzas.stream()
				.filter(pizza -> pizza.getPrice() >= 1300).count();

		assertThat(result, is(3L));
	}

	@Test
	public void test_stream_anyMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		boolean result1 = pizzas.stream()
				.anyMatch(pizza -> pizza.getPrice() >= 1300);

		boolean result2 = pizzas.stream()
				.anyMatch(pizza -> pizza.getPrice() >= 2000);

		assertThat(result1, is(true));
		assertThat(result2, is(false));
	}

	@Test
	public void test_stream_allMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		boolean result1 = pizzas.stream()
				.allMatch(pizza -> pizza.getPrice() >= 1300);

		boolean result2 = pizzas.stream()
				.allMatch(pizza -> pizza.getPrice() >= 900);

		assertThat(result1, is(false));
		assertThat(result2, is(true));
	}

	@Test
	public void test_stream_noneMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		boolean result1 = pizzas.stream()
				.noneMatch(pizza -> pizza.getPrice() >= 2000);

		assertThat(result1, is(true));
	}

	@Test
	public void test_stream_findFirst() throws Exception {
		List<Order> orders = new Data().getOrders();

		Optional<Order> result = orders.stream().filter(order -> order
				.getCustomer().getFirstname().equals("Sophie"))
				.findFirst();

		assertThat(result.isPresent(), is(false));
	}

	/**
	 * FACULTATIVE : PLUS DURE !!
	 */
	@Test
	public void test_stream_filter_adv() throws Exception {
		List<Order> orders = new Data().getOrders();

		List<Order> result = orders.stream()
				.filter(order -> order.getPizzas().stream().anyMatch(
						pizza -> pizza.getName().equals("Pépéroni")))
				.collect(Collectors.toList());

		assertThat(result, hasSize(3));
	}
}
