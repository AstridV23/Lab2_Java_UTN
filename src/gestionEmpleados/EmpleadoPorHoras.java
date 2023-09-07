package gestionEmpleados;

import java.util.Scanner;

public class EmpleadoPorHoras extends Empleado implements Impuesto{
    protected int horasTrabajadas;
    Scanner scanner = new Scanner(System.in);

    public EmpleadoPorHoras(String nombre, int id, int horasTrabajadas) {
        this.nombre = nombre;
        this.id = id;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        int horas_extras;

        if(horasTrabajadas > 40){
            horas_extras = horasTrabajadas - 40;
            return horasTrabajadas * 35 + horas_extras * 45;
        }
        return this.horasTrabajadas * 35;
    }

    @Override
    public void calcularImpuesto() {
        double impuesto = this.calcularSueldo() * 0.10;
        System.out.println("Total impuestos: $"+impuesto);
    }

    public void setHorasTrabajadas() {
        this.horasTrabajadas = scanner.nextInt();
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
}
