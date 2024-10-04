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

        // Gerar números de Fibonacci até o número de entrada
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1); // F(1)
        fibonacci.add(2); // F(2)

        // Gerar números de Fibonacci até que o próximo seja maior que 'num'
        while (true) {
            int nextFib = fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2);
            if (nextFib > num) break;
            fibonacci.add(nextFib);
        }

        // Construir a representação de Zeckendorf
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

        // Se o resultado estiver vazio, significa que o número era 0
        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }

    public static String decode(String input) {
        // Verifica se a entrada contém apenas '0' e '1'
        if (!input.matches("[01]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas '0' e '1'");
        }

        int result = 0;
        List<Integer> fib = new ArrayList<>();

        // Gera a sequência de Fibonacci necessária
        fib.add(0); // F(1)
        fib.add(1); // F(2)

        // Gera Fibonacci até o tamanho da entrada + 2
        while (fib.size() < input.length() + 2) {
            int next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            fib.add(next);
        }

        // Decodifica a entrada
        for (int i = 0; i < input.length(); i++) {
            // Se o bit atual é '1', adiciona o número de Fibonacci correspondente
            if (input.charAt(input.length() - 1 - i) == '1') {
                result += fib.get(i + 2); // Corrige para usar F(i + 2)
            }
        }

        return String.valueOf(result);
    }
}

