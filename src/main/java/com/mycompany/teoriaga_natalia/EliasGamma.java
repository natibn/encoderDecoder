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
public class EliasGamma {

    public static String encode(String input) {
        StringBuilder encodedString = new StringBuilder();

        for (char c : input.toCharArray()) {
            int ascii = (int) c;

            String binary = Integer.toBinaryString(ascii);

            if (ascii == 1) {
                encodedString.append("1 ");
                continue;
            }

            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < binary.length() - 1; i++) {
                prefix.append("0");
            }

            encodedString.append(prefix.toString()).append(binary);
        }

        return encodedString.toString().trim(); 
    }

    public static String decode(String input) {
        StringBuilder decodedString = new StringBuilder();
        
        int i = 0;

        while (i < input.length()) {
            int zeroCount = 0;

            while (i < input.length() && input.charAt(i) == '0') {
                zeroCount++;
                i++;
            }

            if (i < input.length() && input.charAt(i) == '1') {
                i++;
            }

            StringBuilder binary = new StringBuilder("1");
            
            for (int j = 0; j < zeroCount; j++) {
                if (i < input.length()) {
                    binary.append(input.charAt(i));
                    i++;
                }
            }

            int ascii = Integer.parseInt(binary.toString(), 2);

            decodedString.append((char) ascii);
        }

        return decodedString.toString();
    }
}
