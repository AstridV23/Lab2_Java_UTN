package gestionEmpleados;

import java.util.Scanner;

public class EmpleadoComision extends Empleado implements Impuesto{
    protected double sueldoBase;
    protected double ventasRealizadas;

    Scanner scanner = new Scanner(System.in);

    public EmpleadoComision(String nombre, int id, double ventasRealizadas) {
        super();
        this.nombre = nombre;
        this.id = id;
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase * (sueldoBase * 0.30);
    }

    @Override
    public void calcularImpuesto() {
        double impuesto;
        if(this.calcularSueldo()>700000){
            impuesto = this.calcularSueldo() * 0.30;
            System.out.println("Total impuestos: $"+impuesto);
        }else{
            System.out.println("El empleado no es alcanzado por el impuesto");
        }
    }

    @Override
    public void setSueldoBase() {
        this.sueldoBase = scanner.nextDouble();
    }

    @Override
    public double getSueldoBase() {
        return sueldoBase;
    }

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }
}
