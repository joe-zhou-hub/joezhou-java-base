package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class PointWithGenericTypeTest {

    private static class Point<T> {
        private T x;
        private T y;

        T getX() {
            return x;
        }

        void setX(T x) {
            this.x = x;
        }

        T getY() {
            return y;
        }

        void setY(T y) {
            this.y = y;
        }
    }

    @Test
    public void build() {
        Point<Integer> pointA = new Point<>();
        pointA.setX(10);
        pointA.setY(30);
        System.out.println(pointA.getX() + " : " + pointA.getY());

        Point<Double> pointB = new Point<>();
        pointB.setX(10.5);
        pointB.setY(20.5);
        System.out.println(pointB.getX() + " : " + pointB.getY());

        Point<String> pointC = new Point<>();
        pointC.setX("东经125°42′ - 130°10′");
        pointC.setY("北纬44°04′ - 46°40′");
        System.out.println(pointC.getX() + " : " + pointC.getY());
    }
}