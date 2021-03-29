/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab01_nsc;
import java.util.*;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;

/**
 *
 * @author BuuBuu
 */
public class SecurityService implements ISecurityService{
private SecretKey key;
private String planText="";
private Cipher cipher;
private byte[] outdata;

public void inputPlainText(){
    Scanner scr = new Scanner(System.in);
    System.out.println("Enter a Plain Text: ");
    planText = scr.nextLine(); 
}
    @Override
    public void createKey() {
       // inputPlainText();
    try {
        KeyGenerator keyGenerator=KeyGenerator.getInstance("AES"); //DES,AES
        SecureRandom  random = new SecureRandom();
       keyGenerator.init(random); 
       key=keyGenerator.generateKey();
       cipher= Cipher.getInstance("AES");
        System.out.println("Has key created successfully!!!");
       
    } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
        Logger.getLogger(SecurityService.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void dataEncryption() {
    try {
        cipher.init(Cipher.ENCRYPT_MODE,key);
        outdata = cipher.doFinal(planText.getBytes());
        System.out.println("Cipher text: " +new String(outdata));
    } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        Logger.getLogger(SecurityService.class.getName()).log(Level.SEVERE, null, ex);
    }
         
    }

    @Override
    public void dataDecryption() {
         try {
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] out = cipher.doFinal(outdata);
        System.out.println("Plain Text: " + new String(out));
        
    } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        Logger.getLogger(SecurityService.class.getName()).log(Level.SEVERE, null, ex);
    }
         
     
    }
    
}
