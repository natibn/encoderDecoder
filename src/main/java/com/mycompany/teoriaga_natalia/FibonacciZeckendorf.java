/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaga_natalia;

/**
 *
 * @author natib
 */
public class FibonacciZeckendorf {
    public static String encode(String input) {
        int num = Integer.parseInt(input);
        StringBuilder result = new StringBuilder();

        int a = 1, b = 2;
        while (b <= num) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        while (b > 0) {
            if (num >= b) {
                result.append("1");
                num -= b;
            } else {
                result.append("0");
            }
            int temp = b - a;
            b = a;
            a = temp;
        }
        result.append("1");
        return result.toString();
    }

    public static String decode(String input) {
        int a = 1, b = 2, result = 0;
        for (char c : input.toCharArray()) {
            if (c == '1') result += b;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return String.valueOf(result);
    }
}

