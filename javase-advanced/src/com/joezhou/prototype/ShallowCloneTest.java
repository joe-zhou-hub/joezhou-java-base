package com.joezhou.prototype;

import org.junit.Test;

import java.util.Date;

/**
 * @author JoeZhou
 */
public class ShallowCloneTest {
    private static class Sheep implements Cloneable{
        String name;
        Date birth;

        Sheep shallowClone(Sheep sheep) {
            Sheep result = null;
            try {
                result = (Sheep) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    /**
     * 通过DEBUG断点观测两只羊的属性，以及birth属性值的更改是否会同时影响两只羊的birth值。
     */
    @Test
    public void shallowClone() {
        Date birth = new Date();
        Sheep sheepA = new Sheep();
        sheepA.name = "dorset";
        sheepA.birth = birth;
        Sheep sheepB = sheepA.shallowClone(sheepA);
        sheepB.name = "dolly";
        birth.setTime(999999999999L);
    }
}
