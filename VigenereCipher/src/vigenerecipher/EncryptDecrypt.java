/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ShariQ
 */
public class EncryptDecrypt {

    char[] arr={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    List<Character>  Alpha= Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
    ArrayList<Integer> keyList=new ArrayList<Integer>();
    
    ArrayList<Integer> outputList=new ArrayList<Integer>();
    ArrayList<Integer> inputList=new ArrayList<Integer>();
    ArrayList<Integer> collision=new ArrayList<Integer>();
    
    public EncryptDecrypt(String getKey){
        char ch;
        
        for (int i = 0; i < getKey.length(); i++) {
            ch=getKey.charAt(i);

            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==ch){
                    keyList.add(j);
                    break;
                }
            }
        }
        
    }
    
    public String enCrypt(String input){
        char ch;
        int convertNumber;
        for (int i = 0; i < input.length(); i++) {
            ch=input.charAt(i);
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==ch){
                    inputList.add(j);
                    break;
                }
            }
        }
        int kcount=0;
        int cou=0;
        for (int i = 0; i < inputList.size(); i++) {
            convertNumber=(keyList.get(kcount)+ inputList.get(i));
            
            if(convertNumber>26){
                collision.add(i);
            }
            
            convertNumber%=26;
            outputList.add(convertNumber);
            kcount++;
            if(kcount==keyList.size()){
                kcount=0;
            }
        }
        
        String output="";
        kcount=0;
        //int cnt;
        
        for (int i = 0; i < input.length(); i++) {
            ch=input.charAt(i);
            if(Alpha.contains(ch)){
                ch=Alpha.get(outputList.get(kcount));
                kcount++;
                output+=ch;
            }else{
                output+=ch;
            }
        }
        
        return output;
    }
    
    
    public String deCrypt(String input){
        char ch;
        int convertNumber;
        for (int i = 0; i < input.length(); i++) {
            ch=input.charAt(i);
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==ch){
                    inputList.add(j);
                    break;
                }
            }
        }
        int kcount=0;
        
        
        for (int i = 0; i < inputList.size(); i++) {
            convertNumber=inputList.get(i) - (keyList.get(kcount));
            if(convertNumber<0){
                convertNumber*=-1;
            }
            if(collision.contains(i)){
                convertNumber-=26;
            }
            if(convertNumber<0){
                convertNumber*=-1;
            }
            convertNumber%=26;
            outputList.add(convertNumber);
            kcount++;
            if(kcount==keyList.size()){
                kcount=0;
            }
        }
        
        String output="";
        kcount=0;
        //int cnt;
        
        for (int i = 0; i < input.length(); i++) {
            ch=input.charAt(i);
            if(Alpha.contains(ch)){
                ch=Alpha.get(outputList.get(kcount));
                kcount++;
                output+=ch;
            }else{
                output+=ch;
            }
        }
        
        return output;
    }
    
    public void setCollision(ArrayList<Integer> coll){
        collision=coll;
    }

}
