/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.teoriaga_natalia;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author natib
 */
public class Huffman {
    private Map<Character, String> charToCodeMap = new HashMap<>();
    private Map<String, Character> codeToCharMap = new HashMap<>();
    private HuffmanNode root;

    public String encode(String input) {
        buildHuffmanTree(input);
        StringBuilder encodedString = new StringBuilder();

        for (char ch : input.toCharArray()) {
            encodedString.append(charToCodeMap.get(ch));
        }
        return encodedString.toString();
    }

    public String decode(String encoded) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode currentNode = root;

        for (char bit : encoded.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;

            if (currentNode.left == null && currentNode.right == null) {
                decodedString.append(currentNode.character);
                currentNode = root; // Retorna para a raiz para o próximo símbolo
            }
        }
        return decodedString.toString();
    }

    private void buildHuffmanTree(String input) {
        // 1. Calcular as frequências dos caracteres
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // 2. Criar uma fila de prioridade para construir a árvore
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        if (priorityQueue.size() == 1) {
            HuffmanNode soleNode = priorityQueue.poll();
            // Criar um nó pai fictício
            HuffmanNode dummyNode = new HuffmanNode(soleNode.frequency, soleNode, null);
            priorityQueue.add(dummyNode);
        }

        // 3. Construir a árvore de Huffman
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency, left, right);
            priorityQueue.add(parent);
        }
        root = priorityQueue.poll(); // Raiz da árvore de Huffman

        // 4. Gerar os códigos para cada caractere
        generateCodes(root, "");
    }

    // Método recursivo para gerar os códigos
    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            charToCodeMap.put(node.character, code);
            codeToCharMap.put(code, node.character);
            return;
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }
}

