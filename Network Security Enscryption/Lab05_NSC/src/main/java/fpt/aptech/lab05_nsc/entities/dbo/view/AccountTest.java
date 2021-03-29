/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab05_nsc.entities.dbo.view;

import fpt.aptech.lab05_nsc.entities.Account;
import fpt.aptech.lab05_nsc.entities.dbo.AccountServiceImpl;
import java.util.Scanner;

/**
 *
 * @author ThienKim
 */
public class AccountTest {

    public AccountTest() {
    }

    fpt.aptech.lab05_nsc.entities.dbo.AccountServiceImpl obj = new AccountServiceImpl();

    private static void menu() {
        System.out.println("----- Account Management System------");
        System.out.println("1. Find All");
        System.out.println("2. Find One");
        System.out.println("3. Exit");
        System.out.println("---------------------------------------");

    }

    private void GetAccounts() {
        System.out.println("=== Account List ===");
        for (Account a : obj.findAll()) {
            System.out.println("Account Code: " + a.getAccountcode());
            System.out.println("Account Name: " + a.getAccountname());
            System.out.println("Balance: " + a.getBalance());
            System.out.println("-------------------");
        }
    }

    private void GetAccount() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter a account code: ");
        String code = scr.next();
        Account a = obj.findOne(code);
        if (a != null) {
            System.out.println("=== Account Info ===");
            System.out.println("Account Code: " + a.getAccountcode());
            System.out.println("Account Name: " + a.getAccountname());
            System.out.println("Balance: " + a.getBalance());
        } else {
            System.out.println("Empty !!!");
        }
    }

    public static void main(String[] args) {
        AccountTest obj = new AccountTest();
        int opt = 0;
        Scanner scr = new Scanner(System.in);
        do {
            menu();
            System.out.println("Enter an option: ");
            opt = scr.nextInt();
            switch (opt) {
                case 1:
                    obj.GetAccounts();
                    break;
                case 2:
                    obj.GetAccount();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

        } while (opt != 3);
    }

}