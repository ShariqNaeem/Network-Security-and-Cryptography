/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ShariQ
 */
public class PFC {
    String key;
    char[][] array;
    ArrayList<Character> list=new ArrayList(Arrays.asList('a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
    ArrayList<Character> forkey=new ArrayList<>();
    ArrayList<String> pairs=new ArrayList<>();
    
    
    public PFC(String key){
        this.key=key;
        array=new char[5][5];
        for (int i = 0; i < key.length(); i++) {
            if(key.charAt(i)=='j'){
                if(!forkey.contains('i')){
                forkey.add('i');
                }
            }else{
                if(!forkey.contains(key.charAt(i))){
                    forkey.add(key.charAt(i));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(!forkey.contains(list.get(i))){
                forkey.add(list.get(i));
            }
        }
    }
    
    public String encrypt(String input){
        int counter=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j]=forkey.get(counter);
                counter++;
            }
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j]+" ");
            }System.out.println("");
        }
        
        String str=makeStringIJ(input);
        String input2=breakIntoPair(str);
        String dummy="";

        for (int i = 0; i < pairs.size(); i++) {
            
            String temp=pairs.get(i);
            
            int x1=0,x2=0,y1=0,y2=0;
            for (int j = 0; j < temp.length()-1; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if(array[k][l]==temp.charAt(j)){
                            x1=k;
                            y1=l;
                        }
                        
                        if(array[k][l]==temp.charAt(j+1)){
                            x2=k;
                            y2=l;
                        }
                    }
                }
                
                if(x1==x2){
                    dummy+=array[x1][(y1+1)%5];
                    dummy+=array[x2][(y2+1)%5];
                    //dummy+=" ";
                }else
                    if(y1==y2){
                        dummy+=array[(x1+1)%5][y1];
                        dummy+=array[(x2+1)%5][y2];
                        //dummy+=" ";
                    }else{
                        dummy+=array[x1][(y2)%5];
                        dummy+=array[x2][(y1)%5];
                        //dummy+=" ";
                    }
            }
        }
            return dummy;
           
    }
    
    
    public String decrypt(String input){
        String dummy="";
        int x1=0,x2=0,y1=0,y2=0;

        for (int i = 0; i < input.length(); i+=2) {
            for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if(array[k][l]==input.charAt(i)){
                            x1=k;
                            y1=l;
                        }
                        
                        if(array[k][l]==input.charAt(i+1)){
                            x2=k;
                            y2=l;
                        }
                    }
                }
            if(x1==x2){
                    dummy+=array[x1][Math.abs(y1-1)%5];
                    dummy+=array[x2][Math.abs(y2-1)%5];
                    //dummy+=" ";
                }else
                    if(y1==y2){
                        dummy+=array[Math.abs(x1-1)%5][y1];
                        dummy+=array[Math.abs(x2-1)%5][y2];
                        //dummy+=" ";
                    }else{
                        dummy+=array[x1][(y2)%5];
                        dummy+=array[x2][(y1)%5];
                        //dummy+=" ";
                    }
        }
        return dummy;
    }
    
    public String makeStringIJ(String input){
        String str="";
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)=='j'){
                str+='i';
            }else{
                str+=input.charAt(i);
            }
        }
        return str;
    }
    
    public String breakIntoPair(String input){
        String supp="";
        
        if(input.length()%2!=0){
            input+="x";
        }
   
        for (int i = 0; i < input.length(); i+=2) {
            
            if(input.charAt(i)!=input.charAt(i+1) ){
                supp+=Character.toString(input.charAt(i)) + Character.toString(input.charAt(i+1));
                
            }else{
                supp+=Character.toString(input.charAt(i))+Character.toString('x')+Character.toString(input.charAt(i+1));      
            }
        }
        
        if(supp.length()%2!=0){
            supp+="x";
        }else{
            if(supp.charAt(supp.length())==supp.charAt(supp.length()-1)){
                supp=supp.substring(1, supp.length()-2);
            }
        }
        String str="";
        for (int i = 0; i < supp.length(); i+=2) {
            str+=supp.charAt(i)+supp.charAt(i+1);
            pairs.add(Character.toString(supp.charAt(i)) + Character.toString(supp.charAt(i+1)));
            
//            if(supp.charAt(i)!=supp.charAt(i+1)){
//                str+=supp.charAt(i)+supp.charAt(i+1);
//                pairs.add(Character.toString(supp.charAt(i)) + Character.toString(supp.charAt(i+1)));
//            }else{
//                str+=supp.charAt(i)+"x";
//                pairs.add(Character.toString(supp.charAt(i))+Character.toString('x'));
//            }
        }
        
        for (int i = 0; i < pairs.size(); i++) {
            String s=pairs.get(i);
            if(s.charAt(0)==s.charAt(1)){
                
            }
        }
        return str;
    }
}
