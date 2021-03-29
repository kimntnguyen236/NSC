/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab02_nsc.main;
import fpt.aptech.lab02_nsc.SecurityServiceImpl;

import java.util.Scanner;

/**
 *
 * @author BuuBuu
 */
public class ServiceManage {
    private static void menu(){
        System.out.println("------- Service Management System---------");
        System.out.println("1. Create plain Text");
        System.out.println("2. Create key pair");
        System.out.println("3. Encryption");
        System.out.println("4. Decryption");
        System.out.println("5. Exit.");
        System.out.println("------------------------------------------");
        
    }

    public static void main(String[] args) {
        SecurityServiceImpl service = new SecurityServiceImpl();
        Scanner scr = new Scanner(System.in);
         int opt=0;
         do{
             menu();
        System.out.println("Enter an option: ");
        opt = scr.nextInt();
       
        switch (opt) {
            case 1: service.inputPlainText();
            break;
           
            case 2: 
                service.createKeyPair();
                break;
            case 3: service.dataEncryption();
            break;
            case 4: service.dataDecryption();
            break;
            case 5: System.exit((0));
            break;
        }
        } while (opt!=5);
              
        // TODO code application logic here
    }
    
}
