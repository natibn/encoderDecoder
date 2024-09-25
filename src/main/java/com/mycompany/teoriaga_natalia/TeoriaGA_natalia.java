/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.teoriaga_natalia;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author natib
 */
public class TeoriaGA_natalia {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Codificação e Decodificação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JLabel labelInput = new JLabel("Input:");
        JTextField inputField = new JTextField(20);
        
        JLabel labelMethod = new JLabel("Escolha o método:");
        String[] methods = {"Golomb", "Elias-Gamma", "Fibonacci/Zeckendorf", "Huffman"};
        JComboBox<String> methodComboBox = new JComboBox<>(methods);

        JLabel labelResult = new JLabel("Resultado:");
        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);

        JButton encodeButton = new JButton("Codificar");
        JButton decodeButton = new JButton("Decodificar");

        JPanel panel = new JPanel();
        panel.add(labelInput);
        panel.add(inputField);
        panel.add(labelMethod);
        panel.add(methodComboBox);
        panel.add(encodeButton);
        panel.add(decodeButton);
        panel.add(labelResult);
        panel.add(resultArea);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        EncoderDecoder encoderDecoder = new EncoderDecoder();

        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String method = (String) methodComboBox.getSelectedItem();
                String result = encoderDecoder.encode(input, method);
                resultArea.setText(result);
            }
        });

        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String method = (String) methodComboBox.getSelectedItem();
                String result = encoderDecoder.decode(input, method);
                resultArea.setText(result);
            }
        });
    }
}
