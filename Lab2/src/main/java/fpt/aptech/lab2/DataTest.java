/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab2;

import java.util.Scanner;

/**
 *
 * @author sinhtm
 */
public class DataTest {
    
    private static void menu() {
        System.out.println("1. Enter data encrypt ");
        System.out.println("2. Out data encrypt ");
        System.out.println("3. Out data descrypt ");
        System.out.println("4. Exit ");
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int opt = 1;
        DataEncrypt obj = new DataEncrypt();
        do {
            menu();
            System.out.println("Enter option:");
            opt = scanner.nextInt();
            
            switch (opt) {
                case 1:
                    obj.inputData();
                    break;
                case 2:
                    obj.encryptData();
                    break;
                case 3:
                    obj.descryptData();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (opt != 4);
        // TODO code application logic here
    }
    
}
