package com.joezhou.account;

import com.joezhou.account.service.impl.AccountServiceImpl;

/**
 * @author JoeZhou
 */
public class App {
    public static void main(String[] args) {
        new AccountServiceImpl().start();
    }
}
