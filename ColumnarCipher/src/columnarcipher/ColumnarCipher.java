/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package columnarcipher;

import java.util.Scanner;

/**
 *
 * @author ShariQ
 */
public class ColumnarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER KEY:");
        String key=scan.nextLine();
        CTC myObj=new CTC(key);
        
        System.out.println("ENTER MESSAGE WITHOUT SPACES:");
        // WeAreDisCoveredSaveYourself ***
        String msg=scan.nextLine();
        System.out.println("ENCRYPTED CIPHER TEXT");
        myObj.encrypt(msg);
        System.out.println("|||||||||||||||||||||||||||");
        
        System.out.println("DECRYPTED CIPHER TEXT");        
        myObj.Decrypt();
        
        
        
    }
    
}
