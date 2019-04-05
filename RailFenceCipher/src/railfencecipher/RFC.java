/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railfencecipher;

/**
 *
 * @author ShariQ
 */
public class RFC {
    String input;
    
    public RFC(){
        this.input="";
    }
    
    public String Encrypt(String msg){
        this.input=msg;
        String temp1="";
        String temp2="";

        for (int i = 0; i < this.input.length(); i++) {
            if(i%2==0){
                temp1+=this.input.charAt(i);
            }else{
                temp2+=this.input.charAt(i);
            }
        }
        return (temp1+temp2);
    }
    
    public String Decrypt(String msg){
        
        int count=msg.length()/2;
        String temp1="";
        String temp2="";
        String output="";
        
        for (int i = 0; i < msg.length(); i++) {
            if(i<count){
                temp1+=this.input.charAt(i);
            }else{
                temp2+=this.input.charAt(i);
            }
        }
//        int x1=0,x2=0;
//        System.out.println(temp1);
  //      System.out.println(temp2);

//        for (int i = 0; i < msg.length(); i++) {
//            if(i%2==0){
//                output+=temp1.charAt(x1);
//                x1++;
//            }else{
//                output+=temp2.charAt(x2);
//                x2++;
//            }
//        }
        return (temp1+temp2);
    }
}
