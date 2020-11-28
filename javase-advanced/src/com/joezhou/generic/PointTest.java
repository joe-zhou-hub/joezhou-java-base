package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class PointTest {

    private static class Point {
        private Integer integerX;
        private Integer integerY;
        private Double doubleX;
        private Double doubleY;
        private String stringX;
        private String stringY;

        Integer getIntegerX() {
            return integerX;
        }

        void setIntegerX(Integer integerX) {
            this.integerX = integerX;
        }

        Integer getIntegerY() {
            return integerY;
        }

        void setIntegerY(Integer integerY) {
            this.integerY = integerY;
        }

        Double getDoubleX() {
            return doubleX;
        }

        void setDoubleX(Double doubleX) {
            this.doubleX = doubleX;
        }

        Double getDoubleY() {
            return doubleY;
        }

        void setDoubleY(Double doubleY) {
            this.doubleY = doubleY;
        }

        String getStringX() {
            return stringX;
        }

        void setStringX(String stringX) {
            this.stringX = stringX;
        }

        String getStringY() {
            return stringY;
        }

        void setStringY(String stringY) {
            this.stringY = stringY;
        }
    }

    @Test
    public void pointDemo() {
        Point point = new Point();
        point.setIntegerX(10);
        point.setIntegerY(20);
        System.out.println(point.getIntegerX() + " : " + point.getIntegerY());
        point.setDoubleX(10.5);
        point.setDoubleY(20.5);
        System.out.println(point.getDoubleX() + " : " + point.getDoubleY());
        point.setStringX("东经108°25′");
        point.setStringY("北纬108°25′");
        System.out.println(point.getStringX() + " : " + point.getStringY());
    }
}