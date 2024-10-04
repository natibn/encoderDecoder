/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaga_natalia;

/**
 *
 * @author natib
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

            encodedString.append(quotient.toString()).append(remainder).append(" ");
        }

        return encodedString.toString().trim(); 
    }

    public static String decode(String input) {
        StringBuilder decodedString = new StringBuilder();
        String[] encodedChars = input.split(" ");

        for (String encodedChar : encodedChars) {
            int q = encodedChar.indexOf("0");
            String remainder = encodedChar.substring(q + 1);

            int r = Integer.parseInt(remainder, 2);

            int ascii = q * m + r;

            decodedString.append((char) ascii);
        }

        return decodedString.toString(); 
    }
}

