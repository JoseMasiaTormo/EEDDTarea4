import java.util.Scanner;

public class Refactorizado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = sc.nextInt();
        int[] vector = generateVector(dato);
        System.out.println("\nVector inicial hasta :" + dato);
        printVector(1, dato);
        System.out.println("\nVector de primos hasta:" + dato);
        printVector(vector);
    }

    // Generar la criba de Eratóstenes para números primos de 1 a n
    public static int[] generateVector(int dato) {
        boolean[] esPrimo = new boolean[dato+1];
        for (int i = 2; i <= dato; i++) {
            esPrimo[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(dato); i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= dato; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= dato; i++) {
            if (esPrimo[i]) {
                count++;
            }
        }
        int[] primes = new int[count];
        int index = 0;
        for (int i = 2; i <= dato; i++) {
            if (esPrimo[i]) {
                primes[index++] = i;
            }
        }
        return primes;
    }

    // Imprimir un vector con 10 elementos por línea
    public static void printVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0 && i > 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }

    // Imprimir un vector de números consecutivos con 10 elementos por línea
    public static void printVector(int start, int end) {
        for (int i = start; i <= end; i++) {
            if ((i - start) % 10 == 0 && i > start) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
    }
}
