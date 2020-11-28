package com.joezhou.exception;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CustomExceptionTest {
    private static class CustomException extends Exception {

        public CustomException(){ }

        public CustomException(String message) {
            super(message);
            System.out.println("my exception service...");
        }
    }

    @Test
    public void myException() throws CustomException {
        throw new CustomException("你触发了我自己写的异常...");
    }
}
