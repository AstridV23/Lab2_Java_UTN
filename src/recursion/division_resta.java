package recursion;
/*
    Desarrolla un programa que realice la división de dos números enteros
    utilizando tanto el enfoque recursivo como el iterativo con restas sucesivas.
    Implementa ambos enfoques en la misma clase, utilizando la sobrecarga de métodos
    para diferenciarlos. Luego, realiza pruebas utilizando distintos pares de números.
*/
public class division_resta {
    public static double dividir(float endo, float isor) {
        if (isor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        } else if (endo < isor) {
            return 0;
        } else {
            return 1 + dividir(endo - isor, isor);
        }
    }

    public static double dividir(double endo, double isor) {
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
        float endo1, isor1;
        double cociente;

        endo1 = 123.456F;
        isor1 = 3.14159F;

        cociente = dividir(endo1, isor1);

        System.out.println("Cociente (recursividad): " +cociente);

        double endo2, isor2;

        endo2 = 12345.6789;
        isor2 = 444.001;

        cociente = dividir(endo2, isor2);

        System.out.println("Cociente (iteratividad): " +cociente);

    }
}
