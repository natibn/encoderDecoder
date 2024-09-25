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
        int num = Integer.parseInt(input);
        int q = num / m;
        int r = num % m;

        StringBuilder quotient = new StringBuilder();
        for (int i = 0; i < q; i++) {
            quotient.append("1");
        }
        quotient.append("0");

        String remainder = Integer.toBinaryString(r);
        return quotient.toString() + remainder;
    }

    public static String decode(String input) {
        int q = input.indexOf("0");
        String remainder = input.substring(q + 1);
        int r = Integer.parseInt(remainder, 2);

        return String.valueOf(q * m + r);
    }
}


