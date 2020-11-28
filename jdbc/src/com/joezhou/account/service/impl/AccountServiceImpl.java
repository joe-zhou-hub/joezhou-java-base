package com.joezhou.account.service.impl;

import com.joezhou.account.dao.AccountDao;
import com.joezhou.account.dao.impl.AccountDaoImpl;
import com.joezhou.account.service.AccountService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author JoeZhou
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        mainLoop:
        while (true) {
            showMainView();
            switch (scanner.next().toLowerCase()) {
                case "c":
                    create();
                    break;
                case "d":
                    deleteById();
                    break;
                case "u":
                    updateById();
                    break;
                case "q":
                    scanner.close();
                    System.out.println(">> exit...");
                    break mainLoop;
                default:
                    System.out.println(">> Enter error, please re-enter...\n");
                    break;
            }
        }
    }

    @Override
    public int create() {
        System.out.println(">> Enter new username...");
        String username = scanner.next();
        System.out.println(">> Enter new password...");
        String password = scanner.next();
        return accountDao.create(username, password);
    }

    @Override
    public int updateById() {
        System.out.println(">> Enter the ID of the account...");
        int id = scanner.nextInt();
        System.out.println(">> Enter new username...");
        String username = scanner.next();
        System.out.println(">> Enter new password...");
        String password = scanner.next();
        return accountDao.updateById(username, password, id);
    }

    @Override
    public int deleteById() {
        System.out.println(">> Enter the ID of the account...");
        int id = scanner.nextInt();
        return accountDao.deleteById(id);
    }

    private void showMainView() {
        System.out.println("--------------------------------------------------");
        showTableHead();
        System.out.println("--------------------------------------------------");
        List<Map<String, Object>> accounts = accountDao.getAll();
        if (accounts.isEmpty()) {
            System.out.println("no data, please add...");
        } else {
            showTableBody(accounts);
        }
        System.out.println("--------------------------------------------------");
        showUserOperationPanel();
    }

    private void showTableHead() {
        System.out.println("|\tID\t|\tUSERNAME\t|\tPASSWORD\t|\tCREATE_DATE\t|");
    }

    private void showTableBody(List<Map<String, Object>> accounts) {
        for (Map<String, Object> e : accounts) {
            System.out.print("|\t" + e.get("ID") + "\t");
            System.out.print("|\t" + e.get("USERNAME") + "\t");
            System.out.print("|\t" + e.get("PASSWORD") + "\t");
            System.out.print("|\t" + e.get("CREATE_DATE") + "\t");
            System.out.print("|\n");
        }
    }

    private void showUserOperationPanel() {
        System.out.println(">> Please select operation：\n");
        System.out.println("[c] : create account...");
        System.out.println("[d] : delete account...");
        System.out.println("[u] : update account...");
        System.out.println("[q] : exit...");
    }

}