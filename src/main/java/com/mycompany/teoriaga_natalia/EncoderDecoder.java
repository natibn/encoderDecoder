/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaga_natalia;

/**
 *
 * @author natib
 */
public class EncoderDecoder {
    private Huffman huffman = new Huffman();
    public String encode(String input, String method) {
        switch (method) {
            case "Golomb":
                return Golomb.encode(input);
            case "Elias-Gamma":
                return EliasGamma.encode(input);
            case "Fibonacci/Zeckendorf":
                return FibonacciZeckendorf.encode(input);
            case "Huffman":
                return huffman.encode(input);
            default:
                return "Método desconhecido.";
        }
    }

    public String decode(String input, String method) {
        switch (method) {
            case "Golomb":
                return Golomb.decode(input);
            case "Elias-Gamma":
                return EliasGamma.decode(input);
            case "Fibonacci/Zeckendorf":
                return FibonacciZeckendorf.decode(input);
            case "Huffman":
                return huffman.decode(input);
            default:
                return "Método desconhecido.";
        }
    }
}
