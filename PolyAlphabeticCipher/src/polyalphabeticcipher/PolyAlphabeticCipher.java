/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polyalphabeticcipher;

import java.util.Scanner;

/**
 *
 * @author ShariQ
 */
public class PolyAlphabeticCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EncryptionDecryption obj=new EncryptionDecryption();
        
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER INPUT: ");
        String input=scan.nextLine();
        
        System.out.println("\nENCRYPTION USING POLYALPHABETIC CIPHER: ");
        String s=obj.enCrypt(input);
        System.out.println(s);
        
        System.out.println("\nDECRYPTION USING POLYALPHABETIC CIPHER: ");
        System.out.println(obj.deCrypt(s));
        
    }
    
}
