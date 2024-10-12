package ejercicio_6;

public class Buffer {
    private char contenido;       
    // Debe ser compartida, para que los hilos tengan el mismo valor y entonces, se espere
    private static volatile boolean bufferLleno;  

    public synchronized void poner(char c) {
    	// Si el consumidor no ha recogido todavía, esperar hasta que el buffer esté vacío
        while (bufferLleno) {
            try {
                wait(); 
            } catch (InterruptedException e) {
            }
        }

        contenido = c;
        bufferLleno = true;
        notify(); 
    }

    public synchronized char recoger() {
    	// Si el productor no ha añadido, esperar hasta que haya algo en el buffer
        while (!bufferLleno) {
            try {
                wait(); 
            } catch (InterruptedException e) {
            }
        }

        bufferLleno = false;
        notify();
        return contenido;
    }
}
