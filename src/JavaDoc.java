/**

 Esta clase contiene el método main y el método generarPrimos que se encarga de
 generar los números primos de 1 a un número máximo dado utilizando la criba de
 Eratóstenes.
 */
import java.util.Scanner;

public class JavaDoc {
    /**
     * Este método lee un número entero desde la entrada estándar y luego utiliza
     * el método generarPrimos para imprimir los números primos hasta ese número.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(i + 1 + "\t");
        }
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    /**
     * Este método genera un array de enteros que contiene todos los números primos
     * desde 1 hasta un número máximo dado utilizando la criba de Eratóstenes.
     *
     * @param max el número máximo hasta el cual se generarán los números primos
     * @return un array de enteros que contiene los números primos desde 1 hasta
     *         max (o un array vacío si max < 2)
     */
    public static int[] generarPrimos(int max) {
        int i, j;
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (i = 0; i < dim; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            // Criba
            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (j = 2 * i; j < dim; j += i)
                        esPrimo[j] = false;
                }
            }
            // ¿Cuántos primos hay?
            int cuenta = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimo[i])
                    cuenta++;
            }
            // Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            return new int[0]; // Vector vacío
        }
    }
}