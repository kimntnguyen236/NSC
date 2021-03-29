/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.lab2;

import javax.crypto.*;
import java.security.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinhtm
 */
public class DataEncrypt {

    private PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] cipherText;
    private String planText;

    public void createKey() {
        try {
            SecureRandom random = new SecureRandom();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024, random);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DataEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
         planText = scanner.nextLine();
         
         createKey();
    }

    public void encryptData() {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipherText = cipher.doFinal(planText.getBytes());
            System.out.println("Data encryption: " + new String(cipherText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(DataEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void descryptData() {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] outData = cipher.doFinal(cipherText);
            System.out.println("Data encryption: " + new String(outData));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(DataEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
