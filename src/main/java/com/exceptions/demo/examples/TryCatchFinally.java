package com.exceptions.demo.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchFinally {
    
    public static void readFileWithoutCatch() {
        File file = new File("some_file.txt");
        Scanner scanner = null;
        
        // JVM recordando que aca puede existir una excepcion y se tiene que manejar
        scanner = new Scanner(file);
    }
    
    public static void readFileWithCatchAndFinally() {
        File file = new File("some_file.txt");
        Scanner scanner = null;
        
        // Anteriormente, los recursos se manejaban asi, usando el finally para cerrar conexiones vivas
        try {
            scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            if (scanner != null) {
                System.out.println("Closing scanner");
                scanner.close();
            }
        }
    }
    
    public static void readFileWithTryCatchWithResources() {
        try (Scanner scanner = new Scanner(new File("some_file.txt"))){
            // lee el archivo
            // NO necesita el bloque finally para hacer scanner.close()
            // Java lo hace automaticamente para ti, incluso cuando haya una excepcion
            // Hoy en dia se hace de esta manera a partir de java 7
            // No en todos los casos se puede hacer, solo con las clases que implementen la interfaz Autocloseable
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
