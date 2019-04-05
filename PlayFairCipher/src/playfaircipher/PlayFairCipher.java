/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

import java.util.Scanner;
import javax.print.DocFlavor;

/**
 *
 * @author ShariQ
 */
public class PlayFairCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter Key:");
        Scanner scan=new Scanner(System.in);
        String key=scan.nextLine();
        // monarchy
        PFC obj=new PFC(key);
        System.out.println("ENTER PLAIN TEXT:");
        String pt=scan.nextLine();
        //meetmeattheschoolhouse
        String str=obj.encrypt(pt);
        
        System.out.println("\n CIPHER TEXT:\n"+str);
        
        String origi=obj.decrypt(str);
        System.out.println("\n ORIGINAL TEXT:\n"+origi);
        
    }
    
}
