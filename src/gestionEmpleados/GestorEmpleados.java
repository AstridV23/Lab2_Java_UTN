package gestionEmpleados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorEmpleados {
    List<Empleado> staff;
    Scanner scanner = new Scanner(System.in);

    public GestorEmpleados() {
        this.staff = new ArrayList<>();
    }

    void ingresarEmpleado(){
        int choice, id, horas_trabajadas;
        double salario, ventas_realizadas;
        String nombre;

        System.out.println("Selecciona el tipo de empleado: ");
        System.out.println("1) Empleado asalariado\n2) Empleado por hora\n3) Empleado por comisión\n");
        choice = scanner.nextInt();

        System.out.println("Nombre: ");
        nombre = scanner.next();
        System.out.println("ID");
        id = scanner.nextInt();

        switch(choice){
            case 1:
                System.out.println("Salario base: ");
                salario = scanner.nextDouble();
                staff.add(new EmpleadoAsalariado(nombre, id, salario));
                break;

            case 2:
                System.out.println("Horas trabajadas: ");
                horas_trabajadas = scanner.nextInt();
                staff.add(new EmpleadoPorHoras(nombre, id, horas_trabajadas));
                break;

            case 3:
                System.out.println("Ventas realizadas");
                ventas_realizadas = scanner.nextDouble();
                staff.add(new EmpleadoComision(nombre, id, ventas_realizadas));
                break;

            default:
                System.out.println("ERROR: opción incorrecta");
        }
    }

    void eliminarEmpleado(){
        System.out.println("Ingrese la ID del empleado que desea eliminar: ");
        int id = scanner.nextInt();
        staff.removeIf(empleado -> empleado.id == id);
    }

    void editarEmpleado(){
        System.out.println("Ingrese la Id del empleado que desea editar: ");
        int id = scanner.nextInt();

        for(Empleado empleado:staff){
            if(empleado.id == id){
                System.out.println("Nombre: ");
                empleado.setNombre();
                System.out.println("ID: ");
                empleado.setId();
                if(empleado instanceof EmpleadoPorHoras){
                    System.out.println("Horas trabajadas: ");
                    ((EmpleadoPorHoras) empleado).setHorasTrabajadas();
                } else if (empleado instanceof EmpleadoComision) {
                    System.out.println("Ventas realizadas: ");
                    ((EmpleadoComision) empleado).setSueldoBase();
                } else {
                    System.out.println("Salario del empleado: ");
                    empleado.setSueldoBase();
                }
                break;
            }else{
                System.out.println("ERROR: El ID no corresponde a ningún empleado");
            }
        }
    }
    void visualizarEmpleados(){
        for (Empleado empleado : staff){
            System.out.println("Nombre: "+empleado.getNombre());
            System.out.println("ID: "+empleado.getId());
            System.out.println("Salario: "+empleado.calcularSueldo());
            empleado.calcularImpuesto();
            System.out.println("------------------------------------------------");
        }
    }
}
