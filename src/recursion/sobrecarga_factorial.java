package recursion;
/*
    Crea un programa que calcule el factorial de un número utilizando dos métodos diferentes:
    uno utilizando recursión y otro utilizando iteración.
    Estos métodos deben estar en una clase distinta.
    Emplea la sobrecarga de métodos para diferenciar entre las dos implementaciones.
    Realiza pruebas del programa con distintos números enteros.
*/
public class sobrecarga_factorial {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }else if(n==0 || n==1){
            return 1;
        }
        return n * factorial (n-1);
    }
    public static long factorial(long n) {
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
        long result;

        int num1 = 5;

        result = factorial(num1);
        System.out.println("Resultado de "+num1+"!: "+result+" (recursividad)");

        long num2 = 10L;

        result = factorial(num2);
        System.out.println("Resultado de "+num2+"!: "+result+" (iteratividad)");
    }
}
