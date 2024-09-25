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
        int num = Integer.parseInt(input);
        String binary = Integer.toBinaryString(num);

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < binary.length() - 1; i++) {
            prefix.append("0");
        }

        return prefix.toString() + binary;
    }

    public static String decode(String input) {
        int index = input.indexOf("1");
        String binary = input.substring(index);
        return String.valueOf(Integer.parseInt(binary, 2));
    }
}


