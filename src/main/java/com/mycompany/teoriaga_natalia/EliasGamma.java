/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaga_natalia;

/**
 *
 * @author natib
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

            encodedString.append(prefix.toString()).append(binary).append(" ");
        }

        return encodedString.toString().trim(); 
    }

    public static String decode(String input) {
        StringBuilder decodedString = new StringBuilder();
        String[] encodedChars = input.split(" ");

        for (String encodedChar : encodedChars) {
            int index = encodedChar.indexOf("1");

            String binary = encodedChar.substring(index);

            int ascii = Integer.parseInt(binary, 2);

            decodedString.append((char) ascii);
        }

        return decodedString.toString();
    }
}
