/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package columnarcipher;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author ShariQ
 */
public class CTC {
    String key;
    int num[];
    String sequence="";

    char [][] arr;
    
    public CTC(String key){
        this.key = key;
        num=new int[key.length()];
    }
    
    public void encrypt(String input){
        arrangeKey();
        double ceilValue=(double)input.length()/(double)this.key.length();
        int rows=(int)Math.ceil(ceilValue);
        arr=new char[rows][this.key.length()];
        int counter=0;
        
//        [ FOR REMOVE WHITE SPACES]
//        String dummy="";
//        for (int i = 0; i < input.length(); i++) {
//            if(input.charAt(i)!=' '){
//                dummy+=input.charAt(i);
//            }
//        }
//        input=dummy;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < num.length; j++) {
                if(counter<input.length()){
                    arr[i][num[j]]=input.charAt(counter);
                    counter++;
                }else{
                    arr[i][num[j]]='@';
                }
            }
        }
        String seq2=sequence;
        
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println("");
        }
    }
    
    public void Decrypt(){
        for (int i = 0; i < key.length()-1; i++) {
            for (int j = 0; j < num.length; j++) {
                System.out.print(arr[i][num[j]]+" ");
            }
            System.out.println("");
        }
    }
    
    public void arrangeKey(){
        ArrayList list=new ArrayList();
        String[] keyArr=key.split("");
        Arrays.sort(keyArr);
        
        for (int i = 0; i < keyArr.length; i++) {
            list.add(keyArr[i]);
        }
        
        
        for (int i = 0; i < key.length(); i++) {
            num[i]=list.indexOf(key.charAt(i)+"");
            sequence+=num[i];
        }
    }
}
