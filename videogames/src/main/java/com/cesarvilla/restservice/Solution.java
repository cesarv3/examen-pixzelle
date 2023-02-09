package com.cesarvilla.restservice;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		//System.out.println( romanToInt("LVIII"));
		
		//longestCommonPrefix(new String[] {"flower","flow","flight"});
		
		
        
        System.out.println(count("cesarantoniovillaflores"));
		
		
	}
	public static int romanToInt(String s) {         
         char[] arreglo = s.toCharArray();
         int suma = 0, number = 0, prev = 0;
        
        for(int y = arreglo.length -1; y >= 0; y--){
            switch(arreglo[y]){
                case 'I': number = 1; break;//mapa.put('I',1); break;
                case 'V': number = 5; break;
                case 'X': number = 10; break;
                case 'L': number = 50; break;
                case 'C': number = 100; break;
                case 'D': number = 500; break;
                case 'M': number = 1000; break;
            }   
            
            if(number < prev) {
            	suma -=number;
            } else {
            	suma += number;
            }
            prev = number;
        }
        return suma;
    }
	
public static String longestCommonPrefix(String[] strs) {
	String prefix = "";
	
//	for(int x = 0; x < strs.length; x ++) {
//		prefix = strs[x] 
//	}
        return "";
        
        //obtengo la primer letra de la primer palabra
        //Ciclo dentro de las palabras
        //La letra la contienen todas las demas palabras
        //Si si, al prefijo le agrego la siguiente letra de la primer palabra
        //Si no, el prefijo se cambia por la siguiente letra de la primer palabra
        
    }

public static Map<Character,Integer> count(String cadena){
    //recorrer la cadena
    //si la letra no esta en el map, se agrega y suma 1
    //Si ya esta solo suma 1
    int len = cadena.length();
    if (len <= 0) return null;

    Map<Character,Integer> mapa = new HashMap<Character,Integer>();
    
    for(int x = 0; x< len; x++) {
        Character letra = cadena.charAt(x);
        if (!mapa.containsKey(letra)){
            mapa.put(letra,1);
        } else {
            mapa.put(letra, ((int)mapa.get(letra)) + 1);
        }
    }
    return mapa;
}




}
