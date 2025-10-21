package com.exceptions.demo.examples;

public class CatchHierarchy {
    
    // La jerarquia de los errores siempre tiene que ir de lo mas especifico a los mas general
    // El orden de las excepciones va a depender de la logica de negocio aplicada
    
    public static void catchHierarchy() {
        try {
            // Codigo que puede fallar de varias formas
            int[] numbers = {1, 2, 3};
            int result = numbers[1] / 0;
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is impossible");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index array out of bounds");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
