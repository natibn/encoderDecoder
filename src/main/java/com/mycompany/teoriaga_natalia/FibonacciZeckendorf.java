package com.mycompany.teoriaga_natalia;

import java.util.ArrayList;
import java.util.List;

public class FibonacciZeckendorf {
    public static String encode(String input) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            int num = (int) ch;
            String encodedChar = encodeNumber(num);
            String encodedString = encodedChar.toString().trim();
            int length = encodedString.length();
            StringBuilder formattedLength = new StringBuilder();
            for (int i = 0; i < (10-length); i++) {
                formattedLength.append("0");
            }
            if (length != 10){
                encodedChar = formattedLength+encodedChar;
            }
            result.append(encodedChar);
        }

        return result.toString().trim();
    }

    private static String encodeNumber(int num) {
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

        return result.length() == 0 ? "0" : result.toString();
    }

    public static String decode(String input) {
        StringBuilder result = new StringBuilder();

        // Percorre a string em blocos de 10 caracteres
        for (int i = 0; i < input.length(); i += 10) {
            // Extrai a substring de tamanho 10 ou menor se for a última parte
            String encodedChar = input.substring(i, Math.min(i + 10, input.length()));
            int decodedChar = decodeNumber(encodedChar);
            result.append((char) decodedChar);
        }

        return result.toString();
    }

    private static int decodeNumber(String input) {
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

        return result;
    }
}
