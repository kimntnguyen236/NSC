/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab04_nsc.PassEncrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author BuuBuu
 */
public class PasswordSecurity {
    private SecretKey key;
//private String planText="";
private Cipher cipher;
private byte[] outdata;
public void inputPlainText(){
    Scanner scr = new Scanner(System.in);
    System.out.println("Enter a Plain Text: ");
  //  planText = scr.nextLine(); 
}
   
    public void createKey() {
       // inputPlainText();
    try {
        KeyGenerator keyGenerator=KeyGenerator.getInstance("AES"); //DES,AES
        SecureRandom  random = new SecureRandom();
       keyGenerator.init(random); 
       key=keyGenerator.generateKey();
       cipher= Cipher.getInstance("AES");
    //    System.out.println("Has key created successfully!!!");
       
    } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
        Logger.getLogger(PasswordSecurity.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

 
    public String dataEncryption(String pass) {
        createKey();
    try {
        cipher.init(Cipher.ENCRYPT_MODE,key);
        outdata = cipher.doFinal(pass.getBytes());
     //   System.out.println("Cipher text: " +new String(outdata));
    } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        Logger.getLogger(PasswordSecurity.class.getName()).log(Level.SEVERE, null, ex);
    }
         return new String(outdata);
    }

   
    public void dataDecryption() {
         try {
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] out = cipher.doFinal(outdata);
        System.out.println("Plain Text: " + new String(out));
        
    } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        Logger.getLogger(PasswordSecurity.class.getName()).log(Level.SEVERE, null, ex);
    }
         
     
    }
    
}
