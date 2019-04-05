/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polyalphabeticcipher;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ShariQ
 */
public class EncryptionDecryption {
   List<Character>  alphabets= Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'); 
   char[][] array;
   
   public EncryptionDecryption(){
       this.array=new char[][]{
           {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'},
           {'A','S','D','F','G','H','J','K','L','Q','W','E','R','T','Y','U','I','O','P','X','V','Z','C','B','M','N'},
           {'X','V','Z','C','B','M','N','Q','A','W','S','E','D','R','F','T','G','Y','H','U','J','I','K','O','L','P'}
       };
   }
   
   public String enCrypt(String input){
       char ch;
       int column;
       String output="";
       for (int i = 0; i < input.length(); i++) {
           ch=input.charAt(i);
           if(alphabets.contains(ch)){
               column=alphabets.indexOf(ch);
               output+=array[i%3][column];
           }else{
               output+=ch;
           }
       }
       return output;
   }
   
   public String deCrypt(String input){
       char ch;
       String output="";
       for (int i = 0; i < input.length(); i++) {
           ch=input.charAt(i);
           if(alphabets.contains(ch)){
               for (int j = 0; j < 26; j++) {
                   if(array[i%3][j]==ch){
                       output+=alphabets.get(j);
                       break;
                   }
               }
           }else{
               output+=ch;
           }
       }
       return output;
       
   }
}
