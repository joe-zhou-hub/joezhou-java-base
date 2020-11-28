package com.joezhou.exception;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ExceptionTest {
    @Test
    public void tryCatchStructure() {
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序结束...");
        }
        System.out.println("如果异常爆发，我不会被输出...");
    }

    private int returnInTryOrCatchWithBase(int num) {
        try {
            System.out.println(100 / num);
            return 100;
        } catch (Exception e) {
            System.out.println("catch执行...");
            return 200;
        } finally {
            System.out.println("finally执行...");
            num = 300;
        }
    }

    private int[] returnInTryOrCatchWithReference(int num) {
        int[] arr = {0, 1};
        try {
            System.out.println(100 / num);
            arr[0] = 100;
            return arr;
        } catch (Exception e) {
            System.out.println("catch执行...");
            arr[0] = 200;
            return arr;
        } finally {
            System.out.println("finally执行...");
            arr[0] = 300;
        }
    }

    private int returnInTryOrCatchAndFinally(int num) {
        try {
            System.out.println(100 / num);
            return 100;
        } catch (Exception e) {
            System.out.println("catch执行...");
            return 200;
        } finally {
            System.out.println("finally执行...");
            return 300;
        }
    }

    @Test
    public void returnTime() {
        System.out.println(returnInTryOrCatchWithBase(100));
        System.out.println(returnInTryOrCatchWithBase(0));
        System.out.println(returnInTryOrCatchWithReference(100)[0]);
        System.out.println(returnInTryOrCatchWithReference(0)[0]);
        System.out.println(returnInTryOrCatchAndFinally(100));
        System.out.println(returnInTryOrCatchAndFinally(0));
    }

    private void method(int num) throws RuntimeException {
        System.out.println(100 / num);
    }

    @Test
    public void throwsException()  {
        try {
            method(0);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void throwException() {
        int num = 0;
        if (num == 0) {
            throw new ArithmeticException("你的除数不能为0！");
        }
    }

    @Test
    public void multipleCatch() {
        int[] arr = {1, 2};
        int num = 0;
        try {
            arr[0] = 1 / num;
        } catch (NullPointerException | ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
