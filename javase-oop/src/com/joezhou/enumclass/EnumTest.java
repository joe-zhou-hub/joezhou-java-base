package com.joezhou.enumclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class EnumTest {
    @Test
    public void week(){
        Week mon = Week.MON;
        System.out.println(mon);
    }
}

enum Week{

    /**星期一到星期日*/
    MON, TUE, WED, THU, FRI, SAT, SUN;

    /*
        // 上面的枚举属性相当于调用了7次Enum类的构造器代码：
        new Enum<Week>("MON", 0);
        new Enum<Week>("TUE", 1);
        new Enum<Week>("WED", 2);
        new Enum<Week>("THU", 3);
        new Enum<Week>("FRI", 4);
        new Enum<Week>("SAT", 5);
        new Enum<Week>("SUN", 6);
    */
}
