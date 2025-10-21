package com.exceptions.demo.examples;

public class ManualThrowException {
    
    int age;
    
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }
    
    public void registerAge() {
        try {
            setAge(-6);
            
            // Aca manejamos la excepcion especifica que lanzamos en el metodo de setAge
            // se puede manejar una excepcion de orden superior pero eso es mala practica
            // ya que esconde excepciones que no contemplamos en el codigo
        } catch (Throwable e) {
            System.out.println("Error in register: " + e.getMessage());
            // Ask user to pass a correct age
        }
    }
}
