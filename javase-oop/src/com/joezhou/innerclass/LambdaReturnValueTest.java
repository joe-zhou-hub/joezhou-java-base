package com.joezhou.innerclass;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author JoeZhou
 */
public class LambdaReturnValueTest {

    @Test
    public void returnValue(){
        Consumer consumer = p1 -> System.out.println("hello");
        Supplier supplier = () -> 100;
        Function function = p1 -> 100;
        Predicate predicate = p1 -> true;
    }
}
