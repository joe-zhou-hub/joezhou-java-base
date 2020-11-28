package com.joezhou.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author JoeZhou
 */
public class TreeSetTest {

    private static class Student implements Comparable<Student> {
        private String name;
        private int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student student) {
            String prevName = this.name;
            String nextName = student.getName();
            int prevAge = this.age;
            int nextAge = student.getAge();
            return prevAge == nextAge ? prevName.compareTo(nextName) : prevAge - nextAge;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    private static class CustomComparator implements Comparator<Person> {
        @Override
        public int compare(Person personA, Person personB) {
            String nameOfPersonA = personA.getName();
            String nameOfPersonB = personB.getName();
            int result = nameOfPersonA.compareTo(nameOfPersonB);
            if (result == 0) {
                int ageOfPersonA = personA.getAge();
                int ageOfPersonB = personB.getAge();
                result = ageOfPersonA - ageOfPersonB;
            }
            return result;
        }
    }

    private static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    @Test
    public void naturalSort() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("abc");
        treeSet.add("aac");
        treeSet.add("abb");
        treeSet.add("acc");
        treeSet.add("3");
        treeSet.add("1");
        treeSet.add("2");
        System.out.println(treeSet);
    }

    @Test
    public void sortByComparable() {
        TreeSet<Student> treeSet = new TreeSet<>();
        Student studentA = new Student("a", 50);
        Student studentB = new Student("c", 30);
        Student studentC = new Student("b", 30);
        treeSet.add(studentA);
        treeSet.add(studentB);
        treeSet.add(studentC);
        System.out.println(treeSet);
    }

    @Test
    public void sortByComparator() {
        Set<Person> treeSet = new TreeSet<>(new CustomComparator());
        treeSet.add(new Person("b", 18));
        treeSet.add(new Person("b", 15));
        treeSet.add(new Person("a", 9));
        treeSet.add(new Person("a", 9));
        System.out.println(treeSet);
    }

}
