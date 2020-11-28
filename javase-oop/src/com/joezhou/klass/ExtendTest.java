package com.joezhou.klass;

import org.junit.Test;

import java.io.Serializable;

/**
 * @author JoeZhou
 */
public class ExtendTest {
    @Test
    public void employeeAndManager() {
        Manager manager = new Manager();
        double salary = manager.getSalary();
        double bonus = manager.getBonus();
        System.out.println("月总薪水：" + (salary + bonus));
    }
}

class Employee implements Serializable {
    private double salary = 2000.0;

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee implements Serializable {
    private double bonus = 200.0;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
