/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railfencecipher;

import java.util.Scanner;

/**
 *
 * @author ShariQ
 */
public class RailFenceCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan=new Scanner(System.in);
        RFC obj=new RFC();
        System.out.println("ENTER TEXT:");
        String text=scan.nextLine();
        
        String str=obj.Encrypt(text);
        
        System.out.println("Cipher Text:\n"+str);
        
        System.out.println("Original Text:\n"+obj.Decrypt(str));

    }
    
}
