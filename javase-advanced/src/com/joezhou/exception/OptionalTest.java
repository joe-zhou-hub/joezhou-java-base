package com.joezhou.exception;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;

/**
 * @author JoeZhou
 */
public class OptionalTest {
    @Test
    public void option() {

        A a = new A();

        // no good
        if (a != null && a.getB() != null && a.getB().getC() != null) {
            System.out.println(a.getB().getC().getName());
        }

        // good
        // map(): return empty optional if param is null to avoid NullPointException
        String result = Optional.ofNullable(a)
                .map(e -> e.getB())
                .map(e -> e.getC())
                .map(e -> e.getName())
                .orElse(null);
        System.out.println(result);
    }

    @Data
    class A {
        private B b = new B();
    }

    @Data
    class B {
        private C c = new C();
    }

    @Data
    class C {
        private String name = "z4";
    }
}
