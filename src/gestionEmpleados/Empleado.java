package gestionEmpleados;

import java.util.Scanner;

public abstract class Empleado implements Impuesto {

    Scanner scanner = new Scanner(System.in);

    protected String nombre;
    protected int id;
    protected double sueldoBase;

    public abstract double calcularSueldo();

    @Override
    public void calcularImpuesto() {};

    public void setNombre() {
        this.nombre = scanner.next();
    }

    public void setId() {
        this.id = scanner.nextInt();
    }

    public void setSueldoBase() {
        this.sueldoBase = scanner.nextDouble();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }
}
