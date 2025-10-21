1. NO captures Exception genérica (o peor, Throwable).
   * Mal: catch (Exception e) { ... }
   * Por qué: Estás capturando todo, incluyendo NullPointerException y otros bugs que deberías arreglar, no ocultar. Te ciegas a ti mismo.
   * Bien: catch (FileNotFoundException e) { ... }
2. NUNCA dejes un catch vacío.
   * Mal: catch (IOException e) { // TODO: manejar esto }
   * Por qué: Esto se llama "tragarse la excepción". El error ocurre, el programa no lo reporta, y continúa como si nada. Es una bomba de tiempo y es imposible de depurar.
   * Bien (Mínimo): catch (IOException e) { e.printStackTrace(); } (Al menos imprime el error en la consola).
   * Mejor: Usar un sistema de logging (ej. SLF4J, Logback) o mostrar un mensaje al usuario.
3. Usa finally o try-with-resources para limpiar.
   * Siempre cierra tus recursos (Scanner, InputStream, Connection). No hacerlo provoca "fugas de recursos" (resource leaks) que eventualmente pueden tumbar la aplicación.
4. Diferencia entre Checked y Unchecked.
   * Usa Checked Exceptions (throws) para condiciones externas recuperables (Ej. "El servicio web no responde"). Quien te llama debe tener un plan B.
   * Usa Unchecked Exceptions (throw new RuntimeException()) para errores de programación o validaciones internas (Ej. "El email no puede ser nulo"). Quien te llama no debería intentar recuperarse de esto, sino que el programador debe arreglar el bug.
5. No uses excepciones para control de flujo.
   * Las excepciones son lentas. Crean un "stack trace" completo, lo cual es costoso.
   * Mal: try { int valor = miArray[i]; } catch (ArrayIndexOutOfBoundsException e) { break; } (para salir de un bucle).
   * Bien: if (i < miArray.length) { int valor = miArray[i]; } else { break; }