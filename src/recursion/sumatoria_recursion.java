package recursion;

import java.util.Scanner;

/*
Escribe un programa que calcule la sumatoria de los números enteros desde 1
hasta un número dado utilizando una función recursiva. Implementa esta funcionalidad en una clase separada.
Asegúrate de probar la función con diferentes valores de entrada.
*/
public class sumatoria_recursion {

    public static int sumatoria (int n) {
        if(n<0){
            return -1;
        }else if(n==0 || n==1){
            return 1;
        }
        return n + sumatoria (n-1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el número: ");
        int n = input.nextInt();
        int result = sumatoria(n);

        if(result == -1){
            System.out.println("No puede ser negativo");
        }else {
            System.out.println("La sumatoria de los "+n+" primeros números es "+result);
        }
    }


}
