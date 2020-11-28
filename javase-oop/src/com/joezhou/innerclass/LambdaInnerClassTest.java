package com.joezhou.innerclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class LambdaInnerClassTest {
    @Test
    public void lambda() {
        AdditionService additionService = (numA, numB) -> numA + numB;
        System.out.println(additionService.add(10, 20));
    }
}

interface AdditionService {

    /**
     * 两个int数相加的方法
     *
     * @param numA 加法运算的一个数字
     * @param numB 加法运算的另一个数字
     * @return 返回两个数相加的结果
     */
    int add(int numA, int numB);
}