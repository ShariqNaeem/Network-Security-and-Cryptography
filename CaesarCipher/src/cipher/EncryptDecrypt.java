/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 *
 * @author ShariQ
 */
public class EncryptDecrypt {
    int ascii;
    String temp;
    public EncryptDecrypt() {
        ascii=255;
        temp="";
    }
    
    public String enCrypt(String input){
        char alpha;
        String output="";
        int convert;
        for (int i = 0; i < input.length(); i++) {
            alpha=input.charAt(i);
            convert=ascii - (int) alpha;
            alpha= (char) convert;
            temp+=alpha+"`";
        }
        //System.out.println(temp);
        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)!='`')
                output+=temp.charAt(i);
        }
        return output;
    }
    
    public String deCrypt(String input){
        char alpha;
        String output="";
        int convert;
        temp=output;
        for (int i = 0; i < input.length(); i++) {
            alpha=input.charAt(i);
            convert=ascii - (int) alpha;
            alpha= (char) convert;
            temp+=alpha+"`";
        }
        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)!='`')
                output+=temp.charAt(i);
        }
        return output;
    }
}
