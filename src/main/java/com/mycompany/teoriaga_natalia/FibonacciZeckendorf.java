/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaga_natalia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natib
 * @author diegobritto
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
        if (!input.matches("[01]+")) {
            throw new IllegalArgumentException("Entrada deve conter apenas '0' e '1'");
        }

        int result = 0;
        List<Integer> fib = new ArrayList<>();

        // Gera a sequência de Fibonacci suficiente
        fib.add(1); // F(1)
        fib.add(2); // F(2)
        while (fib.size() < input.length() + 2) {
            int next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            fib.add(next);
        }

        // Decodifica a entrada
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(input.length() - 1 - i) == '1') {
                result += fib.get(i + 2); // Corrigido para F(i + 2)
            }
        }

        return String.valueOf(result);
    }
}

