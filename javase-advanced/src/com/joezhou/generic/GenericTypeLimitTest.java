package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class GenericTypeLimitTest {

    private static class Person<T> {}
    private static class Parent {}
    private static class Child extends Parent {}

	@Test
	public void genericTypeLimit() {
		Person<Child> personA = new Person<>();
		Person<Parent> personB = new Person<>();
		allLimit(personA);
		allLimit(personB);
		superLimit(personA);
		superLimit(personB);
		extendsLimit(personA);
		extendsLimit(personB);
	}

	private void allLimit(Person<?> person) {}
	private void superLimit(Person<? super Child> person) {}
	private void extendsLimit(Person<? extends Parent> person) {}
}