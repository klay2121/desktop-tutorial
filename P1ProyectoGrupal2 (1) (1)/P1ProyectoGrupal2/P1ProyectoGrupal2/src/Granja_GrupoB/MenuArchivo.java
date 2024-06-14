package Granja_GrupoB;
import java.util.Scanner;

public class MenuArchivo {
    private Scanner scanner = new Scanner(System.in);
    //*********ENCAPSULAMIENTO *************
    private int opm;
    
    public MenuArchivo(int i) {
    	//***INICIAR DESDE 0 
        this.opm = 0;
    }
    public void archivos() {
        do {
            System.out.println("--  LECTURA DE ARCHIVOS  --");
            System.out.println("[1]. LECTURA ANIMALES CSV.");
            System.out.println("[2]. LECTURA CULTIVOS JSON.");
            System.out.println("[3]. LECTURA PUESTOS CSV.");
            System.out.println("[4]. Salir");
            try {
                opm = Integer.parseInt(scanner.nextLine());
                switch (opm) {
                    case 1:
                        Animal_GrupoB animal = new Animal_GrupoB("", "", "", 0.0, 0,0);
                        animal.leerCSV();
                        break;
                    case 2:
                        Cultivo_GrupoB json = new Cultivo_GrupoB("", "", "", "", 0);
                        json.leerJSON();
                        break;
                    case 3:
                    	Empleados_GrupoB emple = new Empleados_GrupoB ("","","");
                    	emple.leerCSV();
                    	break;
                    case 4:
                        System.out.println("SALIO EXITOSAMENTE DE NUESTRO SERVICIO DE ARCHIVOS GRANJITA_B");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
                //MANEJO DE EXCEPCIONES
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido...");
            }
        } while (opm != 4);
    }

    public void menuAccionesAnimales() {
        do {
            System.out.println("¿Que accion desea realizar?");
            System.out.println("[1]. Dar de comer al animal.");
            System.out.println("[2]. Limpiar el recinto del animal.");
            System.out.println("[3]. Salir");
            //**********MANEJO ENTRADAS INCORRECTAS ***********
            try {
                opm = Integer.parseInt(scanner.nextLine());
                switch (opm) {
                    case 1:
                        System.out.println("Dando de comer al animal ...");
                        break;
                    case 2:
                        System.out.println("Limpiando el recinto del animal...");
                        break;
                    case 3:
                        System.out.println("Gracias por su trabajo");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
                //**********MANEJO DE EXCEPCIONES********
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido...");
            }
        } while (opm != 3);
    }
    
    public void accionesCultivos () {
        do {
            System.out.println("¿Que accion desea realizar?");
            System.out.println("[1]. Riego del cultivo");
            System.out.println("[2]. Fertilizacion del cultivo");
            System.out.println("[3]. Salir");
            System.out.print("Ingrese una opcion: ");
            try {
                opm = Integer.parseInt(scanner.nextLine());
                switch (opm) {
                case 1:
                	  System.out.println("Realizando riego del cultivo...");
                    break;
                case 2:
                	System.out.println("Realizando fertilizacion del cultivo...");
                    break;
                case 3:
                	 System.out.println("Gracias por su trabajo");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;
                }
                //**********MANEJO DE EXCEPCIONES********
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido...");
            }
        } while (opm != 3);
    }
}
