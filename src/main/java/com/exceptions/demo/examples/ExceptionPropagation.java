package com.exceptions.demo.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionPropagation {
    
    // En este punto se "firma" el metodo con la excepcion con el fin de que quien lo llame
    // pues debe controlar la excepcion, se usa para no aplicar logica de control de excepciones en un metodo
    // y se delega la responsabilidad a quien lo llame
    public static String readFirstLine() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("some_file.txt"))) {
            return reader.readLine();
        }
    }
    
    // Este metodo hace uso del metodo readFirstLine() por ende la jvm EXIGE que se controle la excepcion
    // en caso de no hacerlo, sencillamente el progama no compila y notifica por el stack trace
    public static void loadConfig() {
        try {
            String firstLine = readFirstLine();
            System.out.println("Configuration: " + firstLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
