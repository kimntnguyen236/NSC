/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab01_nsc_manage;
import fpt.aptech.lab01_nsc.*;
import java.util.Scanner;
/**
 *
 * @author BuuBuu
 */
public class SecurityMain {

   private static void menu(){
       System.out.println("=======Security System=======");
       System.out.println("1. Create Secret Key ");
       System.out.println("2.Plain Text Input ");
       System.out.println("3. Encryption ");
       System.out.println("4. Decryption ");
       System.out.println("5. Exit");
       System.out.println("=============================");
   }
    public static void main(String[] args) {
        SecurityService service = new SecurityService();
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        do{
            menu();
        
            System.out.println("Enter an option: ");
        
        opt = scanner.nextInt();
        switch (opt){
            case 1: service.createKey();
            break;
            case 2: service.inputPlainText();
            break;
            case 3: service.dataEncryption();
            break;
            case 4: service.dataDecryption();
            break;
            case 5: System.exit((0));
            break;
        }
        } while (opt!=5);
              
    }
    
}
