/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab06;

import fpt.aptech.lab06_nsc.entities.Account;
import java.util.Scanner;

/**
 *
 * @author ThienKim
 */
public class AccountTest {

    private static void menu() {
        System.out.println("---- Account Management ----");
        System.out.println("1. Find All");
        System.out.println("2. Delete Account");
        System.out.println("3. Add New Account");
        System.out.println("4. Exit");
        System.out.println("----------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountManage am = new AccountManage();
        Scanner scanner = new Scanner(System.in);
        int opt;
        do {
            menu();
            System.out.println("Enter a option: ");
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    am.findAll();
                    break;
                case 2:
                    System.out.println("Enter Account Code: ");
                    String id = scanner.next();
                    am.deleteAccount(id);
                    System.out.println("Detele Account completed....");
                    break;
                case 3:
                    Account account = new Account();
                    System.out.println("Enter Account Code: ");
                    String AccCode = scanner.next();
                    account.setAccountCode(AccCode);
                    System.out.println("Enter Account Name: ");
                    String AccName = scanner.next();
                    account.setAccountName(AccName);
                    System.out.println("Enter PinCode: ");
                    String AccPinCode = scanner.next();
                    account.setPinCode(AccPinCode);
                    System.out.println("Enter Account Balance: ");
                    Long AccBalance = scanner.nextLong();
                    account.setBalance(AccBalance);
                    am.AddAccount(account);
                    System.out.println("Add Account completed....");
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (opt != 3);

        // TODO code application logic here
    }

}
