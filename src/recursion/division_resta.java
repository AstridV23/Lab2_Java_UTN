package recursion;

import java.util.Scanner;

/*
    Desarrolla un programa que realice la división de dos números enteros
    utilizando tanto el enfoque recursivo como el iterativo con restas sucesivas.
    Implementa ambos enfoques en la misma clase, utilizando la sobrecarga de métodos
    para diferenciarlos. Luego, realiza pruebas utilizando distintos pares de números.
*/
public class division_resta {
    public static int dividirRecursion(int dend, int isor) {
        if (dend == 0) {
            return 0;
        } else if (dend < isor) {
            return 0;
        } else {
            return 1 + dividirRecursion(dend - isor, isor);
        }
    }
    public static int dividirIteracion(int dend, int isor) {
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

        int cocienteRec = dividirRecursion(dend, isor);
        int cocienteIte = dividirIteracion(dend, isor);

        System.out.println("Recursividad: ");
        System.out.println("cociente: " + cocienteRec);
        System.out.println("Iteración: ");
        System.out.println("cociente: " + cocienteIte);
    }
}
