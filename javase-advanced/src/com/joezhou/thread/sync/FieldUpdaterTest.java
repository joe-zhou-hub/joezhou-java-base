package com.joezhou.thread.sync;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author JoeZhou
 */
public class FieldUpdaterTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Student implements Serializable {
        volatile long id;
        volatile String name;
        volatile int age;
    }

    private Student student;

    @Before
    public void before() {
        student = new Student(1L, "zhao-si", 58);
    }

    @Test
    public void atomicLongFieldUpdater() {
        AtomicLongFieldUpdater<Student> idUpdater =
                AtomicLongFieldUpdater.newUpdater(
                        Student.class, "id");

        System.out.println("++id：" + idUpdater.incrementAndGet(student));
        System.out.println("id：" + student.getId());

        System.out.println("--id：" + idUpdater.decrementAndGet(student));
        System.out.println("id：" + student.getId());

        System.out.println("id+=5 then return："
                + idUpdater.addAndGet(student, 5));
        System.out.println("id：" + student.getId());

        System.out.println("accumulate then return：" +
                idUpdater.accumulateAndGet(student, 5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right - 9) / 4;
                }));
        System.out.println("id：" + student.getId());
    }

    @Test
    public void atomicIntegerFieldUpdater() {
        AtomicIntegerFieldUpdater<Student> ageUpdater =
                AtomicIntegerFieldUpdater.newUpdater(
                        Student.class, "age");

        System.out.println("age++: " + ageUpdater.getAndIncrement(student));
        System.out.println("age：" + student.getAge());

        System.out.println("age--：" + ageUpdater.getAndDecrement(student));
        System.out.println("age：" + student.getAge());

        System.out.println("return then age+=5："
                + ageUpdater.getAndAdd(student, 5));
        System.out.println("age：" + student.getAge());

        System.out.println("return then accumulate" +
                ageUpdater.getAndAccumulate(student, 5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right - 9) / 4;
                }));
        System.out.println("age：" + student.getAge());
    }

    @Test
    public void atomicReferenceFieldUpdater() {
        AtomicReferenceFieldUpdater<Student, String> nameUpdater =
                AtomicReferenceFieldUpdater.newUpdater(
                        Student.class, String.class, "name");

        System.out.println("set name to fei-ji: " +
                nameUpdater.getAndSet(student, "fei-ji"));
        System.out.println("name：" + student.getName());

        System.out.println("cas name to fei-ji: " +
                nameUpdater.compareAndSet(student, "fei-ji", "da-pao"));
        System.out.println("name：" + student.getName());
    }
}