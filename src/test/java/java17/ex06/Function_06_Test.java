package java17.ex06;

import java.util.function.Supplier;

import org.junit.Test;

import java17.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

	// tag::formatAge[]
	String formatAge(Supplier<Person> supplier) {
		Person person = supplier.get();
		int age = person.getAge();
		return "[age=" + age + "]";
	}
	// end::formatAge[]

	@Test
	public void test_supplier_formatAge() throws Exception {
        Supplier<Person> supplier = () -> new Person("John", "Doe", 35, "password");
        String result = formatAge(supplier);

		assert result.equals("[age=35]");
	}

}
