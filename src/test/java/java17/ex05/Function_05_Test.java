package java17.ex05;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

	// tag::functions[]
	Consumer<Person> changePasswordToSecret = person -> person
			.setPassword("secret");

	Consumer<Person> verifyAge = person -> {
		assert person.getAge() > 4;
	};

	Consumer<Person> verifyPassword = person -> {
		assert person.getPassword().equals("secret");
	};
	// end::functions[]

	@Test
	public void test_consumer() throws Exception {
		List<Person> personList = Data.buildPersonList();

		personList.forEach(changePasswordToSecret);
		Consumer<Person> combinedConsumer = verifyAge
				.andThen(verifyPassword);
		personList.forEach(combinedConsumer);

		// personList.forEach...
		for (Person p : personList) {
			verifyAge.accept(p);
			verifyPassword.accept(p);
		}
	}
}
