/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecipher;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ShariQ
 */
public class VigenereCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER KEY:");
        String key=scan.nextLine();
        
        EncryptDecrypt obj1=new EncryptDecrypt(key);
        EncryptDecrypt obj2=new EncryptDecrypt(key);
        
        System.out.println("\nENTER INPUT:");
        String input=scan.nextLine();
        String str=obj1.enCrypt(input);
        
        
        System.out.println("\nENCRYPTION BY USING VIGENERE CIPHER:");
        System.out.println(str);
        
        obj1.outputList.clear();
        //System.out.println(obj1.outputList.toString());
        
        obj2.setCollision(obj1.collision);
        
        System.out.println("\nDECRYPTION BY USING VIGENERE CIPHER:");
        System.out.println(obj2.deCrypt("VAQPUZGIUOIWNZUSXZCHCPXXVQQABIVST"));
        
        
//System.out.println(obj2.outputList.toString());
        
        
        
//    ArrayList<Integer> keyList=new ArrayList<Integer>();
//        for (int i = 0; i < 10; i++) {
//            keyList.add(i);
//        }
//        System.out.println(keyList.toString());

    }
    
}
