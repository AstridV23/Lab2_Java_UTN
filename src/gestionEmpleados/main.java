package gestionEmpleados;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();
        int iniciar, opcion;

        do{
            System.out.println("¿Qué operación desea realizar?");
            System.out.println("1) Egregar empleado \n2) Eliminar empleado\n3) Editar empleado\n4) Listar empleados\n");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1 -> gestor.ingresarEmpleado();
                case 2 -> gestor.eliminarEmpleado();
                case 3 -> gestor.editarEmpleado();
                case 4 -> gestor.visualizarEmpleados();
                default -> System.out.println("ERROR: opción incorrecta");
            }

            System.out.println("¿Quiere realizar otra operación?\n1) SI\n2) NO");
            iniciar = scanner.nextInt();
        }while (iniciar == 1);
        scanner.close();
    }
}
