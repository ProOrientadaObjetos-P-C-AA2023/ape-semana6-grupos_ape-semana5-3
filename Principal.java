import java.util.Scanner;

class Ciudad {
    private String nombre;
    private String provincia;

    public Ciudad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Ciudad: " + nombre + "\nProvincia: " + provincia;
    }
}

class Medico {
    private String nombre;
    private String especialidad;
    private double sueldoMensual;

    public Medico(String nombre, String especialidad, double sueldoMensual) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public String toString() {
        return "- " + nombre + " - sueldo: " + sueldoMensual + " - " + especialidad;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }
}

class Enfermero {
    private String nombre;
    private String tipo;
    private double sueldoMensual;

    public Enfermero(String nombre, double sueldoMensual) {
        this.nombre = nombre;
        this.sueldoMensual = sueldoMensual;
    }

    public  String CalcularTipo(){
        this.tipo = this.sueldoMensual >=1000 ?"Nombramiento":"Contrato";
        return this.tipo;
    }
    public  String getCalcularTipo(){
        return tipo;
    }


    @Override
    public String toString() {
        return "- " + nombre + " - sueldo: " + sueldoMensual + " - " + tipo;
    }
    public double getSueldoMensual() {
        return sueldoMensual;
    }
}


class Hospital {
    private String nombre;
    private Ciudad ciudad;
    private Medico[] medico;
    private Enfermero[] enfermero;
    private int contadorMedicos;
    private int contadorEnfermeros;
    private  String direccion;
    private double calcularTotalSueldos;

    public Hospital(String nombre, Ciudad ciudad,String direccion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.medico = new Medico[100]; // Suponemos un máximo de 100 médicos
        this.enfermero = new Enfermero[100]; // Suponemos un máximo de 100 enfermeros
        this.contadorMedicos = 0;
        this.contadorEnfermeros = 0;
        this.calcularTotalSueldos = 0;
    }

    public void setMedico(Medico medico) {
        this.medico[contadorMedicos] = medico;
        contadorMedicos++;
    }

    public void setEnfermero(Enfermero enfermero) {
        this.enfermero[contadorEnfermeros] = enfermero;
        contadorEnfermeros++;
    }

    public void calcularTotalSueldos( ) {
        calcularTotalSueldos = 0;
        for (int i = 0; i < contadorMedicos; i++) {
            calcularTotalSueldos += medico[i].getSueldoMensual();
        }
        for (int i = 0; i < contadorEnfermeros; i++) {
            calcularTotalSueldos += enfermero[i].getSueldoMensual();
        }
    }
    public double getcalcularTotalSueldos(){
        return this.calcularTotalSueldos;
    }
    @Override
    public String toString(){
        String msj;
        msj = String.format("HOSPITAL %s"
                        +"\nDireccion: %s"
                        +"\nCiudad: %s"
                        +"\nNumero de Especialidades: %d"
                , nombre
                ,direccion
                ,ciudad
                ,contadorEnfermeros+contadorMedicos);

        msj+="\nLista de Medicos(as)\n";
        for (int i = 0; i < contadorMedicos; i++) {
            msj += medico[i].toString();
        }

        msj+="\nLista de Enfermeros(as)\n";
        for (int i = 0; i < contadorEnfermeros; i++) {
            msj += enfermero[i].toString();
        }

        msj += String.format("\nTotal de sueldos a pagar por mes:%.2f",calcularTotalSueldos);

        return msj;
    }
}


public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del hospital");
        System.out.print("\nNombre del hospital: ");
        String nombreHospital = scanner.nextLine();
        System.out.print("Direccion del hospital:");
        String direccion= scanner.nextLine();
        System.out.print("Ciudad del hospital: ");
        String nombreCiudad = scanner.nextLine();
        System.out.print("Provincia de la ciudad: ");
        String provinciaCiudad = scanner.nextLine();

        Ciudad ciudad = new Ciudad(nombreCiudad, provinciaCiudad);
        Hospital hospital = new Hospital(nombreHospital, ciudad,direccion);

        System.out.println("\nIngresar médicos");
        int numeroMedicos;
        System.out.print("Número de médicos: ");
        numeroMedicos = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numeroMedicos; i++) {
            System.out.println("Ingrese los datos del médico " + (i + 1) + ":");
            System.out.print("Nombre y Apellido: ");
            String nombreMedico = scanner.nextLine();
            System.out.print("Especialidad: ");
            String especialidadMedico = scanner.nextLine();
            System.out.print("Sueldo Mensual: ");
            double sueldoMedico = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
            Medico medico = new Medico(nombreMedico, especialidadMedico, sueldoMedico);
            hospital.setMedico(medico);
        }

        System.out.println("\nIngresar enfermeros(as):");
        int numeroEnfermeros;
        System.out.print("Número de enfermeros(as): ");
        numeroEnfermeros = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea
        for (int i = 0; i < numeroEnfermeros; i++) {
            System.out.println("Ingrese los datos del enfermero(a) " + (i + 1) + ":");
            System.out.print("Nombre y Apellido: ");
            String nombreEnfermero = scanner.nextLine();
            System.out.print("Sueldo Mensual: ");
            double sueldoEnfermero = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
            Enfermero enfermero = new Enfermero(nombreEnfermero, sueldoEnfermero);
            hospital.setEnfermero(enfermero);
            enfermero.CalcularTipo();
        }
        hospital.calcularTotalSueldos();
        System.out.println("\n" + hospital);
    }
}