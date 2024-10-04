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

        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(2);

        while (true) {
            int nextFib = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2);
            if (nextFib > num) break;
            fibonacci.add(nextFib);
        }

        boolean firstOne = false;

        for (int i = fibonacci.size() - 1; i >= 0; i--) {
            if (num >= fibonacci.get(i)) {
                result.append("1");
                num -= fibonacci.get(i);
                firstOne = true;
            } else if (firstOne) {
                result.append("0");
            }
        }

        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }

    public static String decode(String input) {
        if (!input.matches("[01]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas '0' e '1'");
        }

        int result = 0;
        List<Integer> fib = new ArrayList<>();

        fib.add(0);
        fib.add(1);

        while (fib.size() < input.length() + 2) {
            int next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            fib.add(next);
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(input.length() - 1 - i) == '1') {
                result += fib.get(i + 2);
            }
        }

        return String.valueOf(result);
    }
}

