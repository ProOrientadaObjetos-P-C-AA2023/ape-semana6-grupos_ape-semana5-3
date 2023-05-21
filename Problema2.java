import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author loja_
 */
class Estudiante{
    private String nombreEst;
    private int edadEst;
    private Materia materia[];

    public Estudiante(String nombreEst, int edadEst) {
        this.nombreEst = nombreEst;
        this.edadEst = edadEst;
    }

    public Materia[] getMateria() {
        return materia;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombreEst=" + nombreEst + ", edadEst=" + edadEst + ", materia=" + "materia" + '}';
    }




}
class Materia{
    private String materia;
    private double notaACD,notaAPE, notaAA;
    private double recuperacion;
    private double notaTotal;
    private String estado;
    private double validacion;


    public Materia(String materia,double notaACD, double notaAPE, double notaAA) {
        this.materia=materia;
        this.notaACD = notaACD;
        this.notaAPE = notaAPE;
        this.notaAA = notaAA;
    }
    public void calcularNota(){
        this.notaTotal=this.notaACD+this.notaAPE+this.notaAA;
    }
    public String calcularEstado(){
        this.estado=this.notaTotal>=7?"APROBADO":"REPROBADO";
        return this.estado;
    }
    public void calcularRecuperacion(){
        this.notaTotal=this.recuperacion+this.notaTotal*0.60;
    }

    public double getRecuperacion() {
        return recuperacion;
    }

    public double getNotaTotal() {
        return notaTotal;
    }

    public double getValidacion() {
        return validacion;
    }


    public void setRecuperacion(double recuperacion) {
        this.recuperacion = recuperacion;
    }

    public void setNotaTotal(double notaTotal) {
        this.notaTotal = notaTotal;
    }

    public void setValidacion(double validacion) {
        this.validacion = validacion;
    }


    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        if (notaTotal>=7){
            return  "Materia{"+materia +
                    ", notaACD=" + notaACD +
                    ", notaAPE=" + notaAPE +
                    ", notaAA=" + notaAA +
                    ", notaTotal=" + notaTotal +
                    ", estado=" + estado + '}';
        }else{
            Scanner teclado=new Scanner(System.in);
            System.out.println("Desea rendir examen de recuperacion para la siguiente materia: 1=si o 0=no o 2=Validacion");
            int acept=teclado.nextInt();
            if (1==acept){
                return "Materia{"+materia +
                        ", notaACD=" + notaACD +
                        ", notaAPE=" + notaAPE +
                        ", notaAA=" + notaAA +
                        ", recuperacion=" + recuperacion +
                        ", notaTotal=" + notaTotal +
                        ", estado=" + estado + '}';
            } else if (0==acept) {
                return "Materia{"+materia +
                        ", notaACD=" + notaACD +
                        ", notaAPE=" + notaAPE +
                        ", notaAA=" + notaAA +
                        ", notaTotal=" + notaTotal +
                        ", estado=" + estado + '}';
            } else if (2==acept) {
                System.out.println("Rendira el examen de validacion");
                return "Materia{"+materia +
                        ", notaACD=" + 2.5 +
                        ", notaAPE=" + 2.5 +
                        ", notaAA=" + 2 +
                        ", Validacion=" + 7 +
                        ", notaTotal=" + 7 +
                        ", estado=" + "APROBADO" + '}';
            }
            String datos="Datos ingresasdos erroneos";
           return  datos;
        }
    }




}
public class Problema2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese sus datos: nombre, edad");
        Estudiante estudiante=new Estudiante(teclado.next(), teclado.nextInt());
        System.out.println("CUANTAS MATERIAS DESEA");
        int numMateria=teclado.nextInt();
        System.out.println(estudiante);
        Materia materia[]=new Materia[numMateria];
        for (int i = 0; i <materia.length; i++) {
            double nota1=random.nextDouble()*3.5;
            double nota2=random.nextDouble()*3.5;
            double nota3=random.nextDouble()*3;
            System.out.println("Ingrese el nombre de las materias: ");
            materia[i] = new Materia(teclado.next().toUpperCase(),nota1,nota2,nota3 );
        }
        for(Materia materiaaux:materia){
            materiaaux.calcularNota();
            materiaaux.calcularEstado();
            materiaaux.setRecuperacion(materiaaux.getEstado().equals("REPROBADO")?3:0);
            if (materiaaux.getEstado().equals("REPROBADO")){
                    materiaaux.calcularRecuperacion();
                    materiaaux.calcularEstado();
                    materiaaux.getValidacion();
            }
            System.out.println(materiaaux);
        }
    }
}
