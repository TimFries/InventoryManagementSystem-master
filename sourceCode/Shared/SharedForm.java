/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shared;

/**
 *
 * @author Tim
 */
public class SharedForm {
    
    /*public static boolean checkTextFormat(){
        
    }*/
    public static boolean checkSameWords(String a, String b){
        b = b.trim();
        a = a.trim();
        return a.equals(b);
    }
    
    
}
