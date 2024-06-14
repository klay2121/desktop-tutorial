package Granja_GrupoB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Empleados_GrupoB {
	protected Scanner scanner = new Scanner (System.in);
	//****REFERENCIADOS ***
    protected String name, position, serviceType;
    
    public Empleados_GrupoB(String name, String position, String serviceType) {
        this.name = name;
        this.position = position;
        this.serviceType = serviceType;
    }

    public void datoEmpleado(Empleados_GrupoB empleado) {
            System.out.println("°°°° BIENVENID@S A LA GRANJITA GRUPO B °°°°");
            System.out.println("--    INGRESE LOS DATOS DEL EMPLEADO --");
            System.out.println("Ingrese su nombre: ");
            name = scanner.nextLine();
            boolean puestoValido = false;

            while (!puestoValido) {
                System.out.println("Ingrese su puesto (cuidador/agricola): ");
                position = scanner.nextLine();

                if (position.equalsIgnoreCase("cuidador")) {
                    String answer;
                    do {
                        System.out.println("¿Desea agregar un animal? (Si/No)");
                        answer = scanner.nextLine();
                    } while (!answer.equalsIgnoreCase("Si") && !answer.equalsIgnoreCase("No"));

                    if (answer.equalsIgnoreCase("Si")) {
                        Animal_GrupoB animal = new Animal_GrupoB("", "", "", 0, 0,0);
                        animal.ingresoAni();
                    }
                    puestoValido = true; 
                } else if (position.equalsIgnoreCase("agricola")) {
                    String answer;
                    do {
                        System.out.println("¿Desea agregar un cultivo? (Si/No)");
                        answer = scanner.nextLine();
                    } while (!answer.equalsIgnoreCase("Si") && !answer.equalsIgnoreCase("No"));

                    if (answer.equalsIgnoreCase("Si")) {
                        Cultivo_GrupoB cultivo = new Cultivo_GrupoB("", "", "", "", 0);
                        cultivo.datCultivo(empleado);
                    }
                    puestoValido = true; 
                } else {
                    System.out.println("Lo sentimos, no hay ese puesto en nuestra granja.");
                    String answer;
                    do {
                        System.out.println("¿Desea agregar sus servicios en esta granja? (Si/No)");
                        answer = scanner.nextLine();
                    } while (!answer.equalsIgnoreCase("Si") && !answer.equalsIgnoreCase("No"));
                    if (answer.equalsIgnoreCase("Si")) {
                        System.out.println("Puesto que trata de ofrecer :");
                        position = scanner.nextLine();
                        System.out.println("Indique de que trata su servicio: ");
                         serviceType = scanner.nextLine();
                        System.out.println("Servicio aceptado: " + position);
                        System.out.println("Descripcion: " + serviceType);
                        puestoValido = true; 
                        guardarCSV();
                    } else {
                        break;
                    }
                }
            }
        }
    //GUARDAR CSV
    public void guardarCSV() {
        String filePath = "puestosNuevos.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(name + "," + position + "," + serviceType );
            writer.newLine();
            System.out.println("### DATOS GUARDADOS CORRECTAMENTE EN CSV ###");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void leerCSV () {
    String filePath = "puestosNuevos.csv";
    try (BufferedReader reader = new BufferedReader (new FileReader (filePath))){
    	System.out.println("Datos cargados desde csv");
    	String line;
    	while (((line=reader.readLine()) !=null)){
    		System.out.println(line);
    	}
    	}catch (IOException e ) {
    	e.printStackTrace();
    	}
    }
    public void empleadoDat () {
    	System.out.println("NOMBRE EMPLEADO: " + name);
    	System.out.println("PUESTO: " + position);
    }
}