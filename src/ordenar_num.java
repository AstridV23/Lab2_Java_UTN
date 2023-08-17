import java.util.Scanner;
public class ordenar_num {

    /*
    Dado un conjunto de tres números ingresados por el usuario a través de la consola,
    el programa debe ordenarlos de mayor a menor y mostrar el resultado por pantalla.
    */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2, num3;
        System.out.println("Ingrese 3 números: ");
        System.out.println("Primer número: ");
        num1 = input.nextInt();
        System.out.println("Segundo número: ");
        num2 = input.nextInt();
        System.out.println("Tercer número: ");
        num3 = input.nextInt();

        if(num1 > num2 && num1 > num3){
            if(num2 > num3){
                System.out.println("Números ordenados: " +num1+" "+num2+" "+num3);
            }else{
                System.out.println("Números ordenados: " +num1+" "+num3+" "+num2);
            }
        } else if (num2 > num1 && num2 > num3) {
            if(num1 > num3){
                System.out.println("Números ordenados: " +num2+" "+num1+" "+num3);
            }else{
                System.out.println("Números ordenados: " +num2+" "+num3+" "+num1);
            }
        }else {
            if(num1 > num2){
                System.out.println("Números ordenados: " +num3+" "+num1+" "+num2);
            }else{
                System.out.println("Números ordenados: " +num3+" "+num2+" "+num1);
            }
        }

    }
}
