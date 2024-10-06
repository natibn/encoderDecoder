/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaga_natalia;

/**
 *
 * @author natib
 * @author julianrsouza
 */
public class Golomb {
    private static int m = 5;

    public static String encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            int ascii = (int) c;

            int q = ascii / m;
            int r = ascii % m;

            StringBuilder quotient = new StringBuilder();

            for (int i = 0; i < q; i++) {
                quotient.append("1");
            }
            quotient.append("0");

            int numBitsRemainder = (int) Math.ceil(Math.log(m) / Math.log(2));
            String remainder = String.format("%" + numBitsRemainder + "s", Integer.toBinaryString(r)).replace(' ', '0');

            encodedString.append(quotient.toString()).append(remainder);
        }

        return encodedString.toString().trim(); 
    }

    public static String decode(String input) {
        StringBuilder decodedString = new StringBuilder();
        int remainderBitsLength = (int) Math.ceil(Math.log(m) / Math.log(2));
    
        int currentIndex = 0;
    
        while (currentIndex < input.length()) {
            int quotient = 0;
            while (currentIndex < input.length() && input.charAt(currentIndex) == '1') {
                quotient++;
                currentIndex++;
            }
    
            if (currentIndex < input.length() && input.charAt(currentIndex) == '0') {
                currentIndex++;
            }
    
            StringBuilder remainderBinary = new StringBuilder();
            for (int i = 0; i < remainderBitsLength && currentIndex < input.length(); i++) {
                remainderBinary.append(input.charAt(currentIndex));
                currentIndex++;
            }
    
            int remainder = Integer.parseInt(remainderBinary.toString(), 2);
    
            int ascii = quotient * m + remainder;
    
            decodedString.append((char) ascii);
        }
    
        return decodedString.toString();
    }
    
}


