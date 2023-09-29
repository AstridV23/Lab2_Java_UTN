package ParcialLAB;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface Informacion{
    void verHistorialDeEventos();
}

abstract class Persona implements Serializable{
    private String Nombre;
    private int DNI;
    private String Fecha_nacimiento;

    public Persona() {
    }

    public Persona(String nombre, int DNI, String fecha_nacimiento) {
        Nombre = nombre;
        this.DNI = DNI;
        Fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        Fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", DNI=" + DNI +
                ", Fecha_nacimiento=" + Fecha_nacimiento +
                '}';
    }
}

class Doctores extends Persona implements Serializable{
    private String Especialidad;

    public Doctores() {
    }

    public Doctores(String nombre, int DNI, String fecha_nacimiento, String especialidad) {
        super(nombre, DNI, fecha_nacimiento);
        Especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Doctores{" +
                "Especialidad='" + Especialidad + '\'' +
                '}';
    }
}

class Pasciente extends Persona implements Informacion, Serializable {
    Scanner input = new Scanner(System.in);

    private int numTelefono;
    private int tipoSangre;
    ArrayList<String> eventos = new ArrayList<>();

    public Pasciente() {
    }

    public Pasciente(String nombre, int DNI, String fecha_nacimiento, int numTelefono, int tipoSangre) {
        super(nombre, DNI, fecha_nacimiento);
        this.numTelefono = numTelefono;
        this.tipoSangre = tipoSangre;
    }

    public void agregarEventos(String fecha, String evento){
        eventos.add(fecha + " - " + evento);
    }

    public void vaciarHistorial(){
        eventos.clear();
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(int tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    @Override
    public void verHistorialDeEventos() {
        for(String s : eventos){
            System.out.println(s+"\n");
        }
    }


}

class GestionPascientes implements Serializable{
    Scanner input = new Scanner(System.in);
    ArrayList<Pasciente> pascientes = new ArrayList<>();
    ArrayList<Doctores>  doctores = new ArrayList<>();

    public void agregarPasciente(){
        System.out.println("Ingresa los datos del pasciente: ");
        String nombre = input.nextLine();
        input.nextInt();
        int dni = input.nextInt();
        String fecha_nac = input.nextLine();
        input.nextLine();
        int numTel = input.nextInt();
        input.nextInt();
        int tipoSangre = input.nextInt();
        input.nextInt();

        pascientes.add(new Pasciente(nombre, dni, fecha_nac, numTel, tipoSangre));
    }

    public void agregarDoctor(Doctores doctor){
        doctores.add(doctor);
    }

    public void actualizarInformacion(){
        System.out.println("Indique el DNI del paciente a buscar: ");
        int dni = input.nextInt();

        for(Pasciente p : pascientes){
            if(p.getDNI() == dni){
                System.out.println("Indique nuevo número de telefono: ");
                int numTel = input.nextInt();
                input.nextInt();
                p.setNumTelefono(numTel);
            }else{
                System.out.println("Pasciente no encontrado");
            }
        }
    }

    public void nuevoHistorial(){
        System.out.println("Indique el DNI del paciente a buscar: ");
        int dni = input.nextInt();
        input.nextInt();

        for(Pasciente p : pascientes){
            if(p.getDNI() == dni){
                p.vaciarHistorial();
            }else{
                System.out.println("Pasciente no encontrado");
            }
        }
    }

    public void listarDoctores(){
        System.out.println("Lista de doctores: ");
        for(Doctores d : doctores){
            System.out.println(d+"\n");
        }
    }

    public void historialMedico(){
        System.out.println("Indique el DNI del paciente a buscar: ");
        int dni = input.nextInt();

        for(Pasciente p : pascientes){
            if(p.getDNI() == dni){
                System.out.println("HISTORIAL MÉDICO: ");
            }else{
                System.out.println("Pasciente no encontrado");
            }
        }
    }

    public void guardar(String rutaArchivo){
        try (FileOutputStream fileOutputStream = new FileOutputStream(rutaArchivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(this);
            System.out.println("Estado de la concesionaria guardado en " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar la concesionaria en el archivo " + rutaArchivo);
            e.printStackTrace();
        }
    }

    public void cargar(String rutaArchivo){
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            System.out.println("El archivo no existe en la ruta especificada. Se creará uno nuevo.");
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            GestionPascientes pascientesCargados = (GestionPascientes) objectInputStream.readObject(); // cambiar
            this.pascientes = pascientesCargados.pascientes;

            System.out.println("Estado de la concesionaria cargado desde " + rutaArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar la concesionaria desde el archivo " + rutaArchivo);
            e.printStackTrace();
        }
    }

    public String leerDatos(String rutaArchivo){

        try {
            File archivo = new File(rutaArchivo);

            if (!archivo.exists()) {
                return "El archivo no existe.";
            }

            FileReader fileReader = new FileReader(archivo);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            bufferedReader.close();

            String contenidoDatos = contenido.toString();
            return contenidoDatos;
        } catch (IOException e) {
            return "Error al leer los datos del hospital: " + e.getMessage();
        }
    }
}

public class Hospital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        GestionPascientes gestionPascientes = new GestionPascientes();

        Doctores doctor1 = new Doctores("Dr. Smith", 123456789, "15/05/1975", "Cardiología");
        Doctores doctor2 = new Doctores("Dra. Johnson", 987654321, "20/03/1980", "Neurología");
        Doctores doctor3 = new Doctores("Dr. Wilson", 456789123, "10/11/1982", "Cirugía General");
        Doctores doctor4 = new Doctores("Dra. Lee", 789123456, "05/09/1978", "Pediatría");
        Doctores doctor5 = new Doctores("Dr. Brown", 654321987, "30/07/1985", "Dermatología");

        gestionPascientes.agregarDoctor(doctor1);
        gestionPascientes.agregarDoctor(doctor2);
        gestionPascientes.agregarDoctor(doctor3);
        gestionPascientes.agregarDoctor(doctor4);
        gestionPascientes.agregarDoctor(doctor5);

        String archivoDatos = "datos.txt";
        String archivoPascientes = "pascientes.txt";

        String datosHospital = gestionPascientes.leerDatos(archivoDatos);
        gestionPascientes.cargar(archivoPascientes);

        boolean salir = false;

        System.out.println("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                """
                +datosHospital+
                """
                Menú:
                        1. Listar Doctores.
                        2. Registrar un nuevo paciente.
                        3. Actualizar información personal de un paciente.
                        4. Consultar el historial médico de un paciente.
                        5. Nuevo historial para un paciente.\s
                        6. Guardar Historial de pacientes en archivo\s
                        7. Cargar Historial de pacientes desde archivo\s
                        8. Salir.
                """);

        int opc = input.nextInt();
        input.nextLine();

        while (!salir){
            switch (opc){
                case 1:
                    gestionPascientes.listarDoctores();
                    break;
                case 2:
                    gestionPascientes.agregarPasciente();
                    break;
                case 3:
                    gestionPascientes.actualizarInformacion();
                    break;
                case 4:
                    gestionPascientes.historialMedico();
                    break;
                case 5:
                    gestionPascientes.nuevoHistorial();
                    break;
                case 6:
                    gestionPascientes.guardar(archivoPascientes);
                    break;
                case 7:
                    gestionPascientes.cargar(archivoPascientes);
                    break;
                case 8:
                    salir = true;
                    gestionPascientes.guardar(archivoPascientes);
                    break;
                default:
                    System.out.println("ERROR. Opción incorrecta");
            }
        }
    }
}
