package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class SuperTest {
    @Test
    public void animalAndBirdAndDog() {
        System.out.println(new Bird().getName());
        new Dog().methodA();
    }

    @Test
    public void thisTransfer() {
        new Dog().printThisInDog();
    }
}

class Animal {
    private String name;

    Animal() {
    }

    Animal(String name) {
        this.name = name;
    }

    void move() {
        System.out.println("All animals can move！");
    }

    void printThisInAnimal() {
        System.out.println("this of Animal: " + this);
    }

    String getName() {
        return name;
    }
}

class Bird extends Animal {
    Bird() {
        super("jing-wei");
    }
}

class Dog extends Animal {
    Dog() {
        super.move();
    }

    void methodA() {
        super.move();
    }

    void printThisInDog() {
        System.out.println("this in Dog: " + this);
        printThisInAnimal();
    }
}
