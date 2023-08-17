package recursion;

import java.util.Scanner;

/*
    Forma iterativa
    Desarrolla un programa que realice la división de dos números enteros
    utilizando tanto el enfoque recursivo como el iterativo con restas sucesivas.
    Implementa ambos enfoques en la misma clase, utilizando la sobrecarga de métodos
    para diferenciarlos. Luego, realiza pruebas utilizando distintos pares de números.
*/
public class division_resta_iteracion {
    public static int divide(int dend, int isor) {
        int cociente = 0;

        while (dend >= isor) {
            dend -= isor;
            cociente++;
        }

        return cociente;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dend, isor;
        System.out.println("Dividendo: ");
        dend = input.nextInt();
        System.out.println("Divisor: ");
        isor = input.nextInt();

        int cociente = divide(dend, isor);

        System.out.println("cociente: " + cociente);
    }
}
