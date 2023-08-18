package recursion;
import java.util.Scanner;
/*
    Desarrolla un programa que realice la división de dos números enteros
    utilizando tanto el enfoque recursivo como el iterativo con restas sucesivas.
    Implementa ambos enfoques en la misma clase, utilizando la sobrecarga de métodos
    para diferenciarlos. Luego, realiza pruebas utilizando distintos pares de números.
*/
public class division_resta {
    public static int dividir(int endo, int isor) {
        if (isor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        } else if (endo < isor) {
            return 0;
        } else {
            return 1 + dividir(endo - isor, isor);
        }
    }

    public static float dividir(float endo, float isor) {
        if (isor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }

        int cociente = 0;

        while (endo >= isor) {
            endo -= isor;
            cociente++;
        }

        return cociente;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float endo, isor;

        System.out.println("Dividendo: ");
        endo = input.nextFloat();
        System.out.println("Divisor: ");
        isor = input.nextFloat();

        int cocienteRecInt = dividir((int) endo, (int) isor);
        float cocienteRecFloat = dividir(endo, isor);

        System.out.println("Recursivo (entero): ");
        System.out.println("Cociente: " + cocienteRecInt);

        System.out.println("Recursivo (flotante): ");
        System.out.println("Cociente: " + cocienteRecFloat);
    }
}
