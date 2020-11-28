package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class InstanceOfTest {

    @Test
    public void instanceOf() {
        Superman superman = new Superman();
        Hero hero = new Hero();

        System.out.println(superman instanceof Hero);
        System.out.println(superman instanceof Superman);
        System.out.println(hero instanceof Hero);
        System.out.println(hero instanceof Superman);

        hero = new Superman();
        superman = (Superman) new Hero();

        superman = (Superman) hero;
        System.out.println(hero instanceof Hero);
        System.out.println(hero instanceof Superman);
        System.out.println(superman instanceof Hero);
        System.out.println(superman instanceof Superman);
    }
}

class Hero {
}

class Superman extends Hero {
}
