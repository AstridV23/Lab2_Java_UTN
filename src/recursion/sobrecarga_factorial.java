package recursion;

import java.util.Scanner;

/*
    Crea un programa que calcule el factorial de un número utilizando dos métodos diferentes:
    uno utilizando recursión y otro utilizando iteración.
    Estos métodos deben estar en una clase distinta.
    Emplea la sobrecarga de métodos para diferenciar entre las dos implementaciones.
    Realiza pruebas del programa con distintos números enteros.
*/
public class sobrecarga_factorial {
    public static int factorialRecursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }else if(n==0 || n==1){
            return 1;
        }
        return n * factorialRecursion (n-1);
    }
    public static int factorialIteracion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Calcular el factorial de: ");
        int num = input.nextInt();

        int resultRec = factorialIteracion(num);
        int resultIte = factorialRecursion(num);

        System.out.println("Forma recursiva: ");
        System.out.println("El factorial de " + num + " es: " + resultRec);
        System.out.println("Forma iterativa: ");
        System.out.println("El factorial de " + num + " es: " + resultIte);

    }
}
