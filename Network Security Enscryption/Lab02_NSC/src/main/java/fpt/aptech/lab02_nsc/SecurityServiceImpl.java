/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab02_nsc;
import java.util.*;
import java.io.*;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;

/**
 *
 * @author BuuBuu
 */
public class SecurityServiceImpl implements SecurityService
{
    private String plainText="";
    private byte[] cipherText;
   // private Cipher cipher;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    
    public void inputPlainText(){
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        plainText = scr.nextLine();
        System.out.println("Plain Text: " +plainText);
    }

    @Override
    public void createKeyPair() {
       
        try { SecureRandom random = new SecureRandom();
        KeyPairGenerator keyPairGenerator;
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
             keyPairGenerator.initialize(1024,random);
             KeyPair keyPair = keyPairGenerator.generateKeyPair();
             publicKey = keyPair.getPublic();
             privateKey = keyPair.getPrivate();
             
             System.out.println("Create key completed!!! ");
             
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void dataEncryption() {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipherText=cipher.doFinal(plainText.getBytes());
            
             System.out.println("Cipher text: " +  new String (cipherText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(SecurityServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void dataDecryption() {
     
        try {
            Cipher cipher = Cipher.getInstance("RSA"); 
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] outplainText = cipher.doFinal(cipherText);
            
            System.out.println("Plain Text: "+ new String (outplainText));
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(SecurityServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
   
   
}
