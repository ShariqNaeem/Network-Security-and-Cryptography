/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.util.Scanner;

/**
 *
 * @author ShariQ
 */
public class Cipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //char a='A';
        //System.out.println((int) a);
        System.out.println("Enter Input:");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
                
        System.out.println("\nEncryption:");
        EncryptDecrypt obj=new EncryptDecrypt();
        String encrypt=obj.enCrypt(input);
        System.out.println(encrypt);
        
        System.out.println("Decryption:");
        String decrypt=obj.deCrypt(encrypt);
        System.out.println(decrypt);
    }
    
}
