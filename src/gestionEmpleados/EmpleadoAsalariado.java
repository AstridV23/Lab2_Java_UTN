package gestionEmpleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto{
    protected double sueldoMensual;

    EmpleadoAsalariado(String nombre, int id, double salario){
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = salario;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase;
    }

    @Override
    public void calcularImpuesto() {
        super.calcularImpuesto();
        double impuesto = this.calcularSueldo() * 0.10;
        System.out.println("Total impuestos: $"+impuesto);
    }
}
