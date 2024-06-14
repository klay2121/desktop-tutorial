package Granja_GrupoB;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Cultivo_GrupoB  extends Granja_GrupoB {
	protected Scanner scanner = new Scanner(System.in);
	//******** ATRBUTOS PROPIOS ********
	//REFERENCIADOS
	protected String  performance;
	//PRIMITIVOS
    protected int cultivationArea;
    //protected int cantCultivos;
   //*************** CONSTRUCTOR ***************
    public Cultivo_GrupoB (String name, String type, String productionClass,String performance, int cultivationArea ){
    super (name, type, productionClass); //**** ATRIBUTOS HEREDADOS ****
    this.cultivationArea = cultivationArea;
    this.performance = performance;
    }
    //************* METODOS ************
    public void datCultivo (Empleados_GrupoB empleado) {
    	ingresoDato ();
    	do {
    	System.out.println("Ingrese el area de cultivo [1-25] en metros: ");
    	cultivationArea = scanner.nextInt();
    	}while(cultivationArea<1 || cultivationArea>25) ;
    	scanner.nextLine();
    	System.out.println("Ingrese el rendimiento del cultivo: ");
    	performance = scanner.nextLine();
    	System.out.println("°°° DATOS IMPRESOS CULTIVOS °°°");
    	empleado.empleadoDat(); 
        imprimirDat();
    	System.out.println("AREA CULTIVO: " + cultivationArea);
    	System.out.println("RENDIMIENTO CULTIVO: " + performance);
    	System.out.println("----------------------------------");
    	realizarAccionesCulti ();
    	
}
    //***************POLIMORFISMO**************
    @Override
    public void  imprimirDat() {
		System.out.println("NOMBRE : " + name);
		System.out.println("TIPO: " + type);
		System.out.println("PRODUCCION: " + productionClass);
    }
    public void realizarAccionesCulti () {
    	MenuArchivo dato = new MenuArchivo (0);
    	dato.accionesCultivos();
    	guardarJSON ();
        String answer;
        do {
            System.out.println("¿Desea agregar otro puesto? (Si/No)");
            answer = scanner.next();

            if (answer.equalsIgnoreCase("Si")) {
                Empleados_GrupoB empleado = new Empleados_GrupoB("", "", "");
                empleado.datoEmpleado(empleado);
            } else if (answer.equalsIgnoreCase("No")) {
                return; 
            } else {
                System.out.println("Si/No");
            }
        } while (true);
    
    }
 // *************GUARDAR ARCHIVOS JSON *****************
    public void guardarJSON () {
    	String filePath = "cultivo.json";
    	JSONObject cultivoJSON = new JSONObject ();
    	cultivoJSON.put("NOMBRE CULTIVO" , name);
    	cultivoJSON.put("TIPO CULTIVO" , type);
    	cultivoJSON.put("CLASE PRODUCCION CULTIVO" , productionClass);
    	cultivoJSON.put("AREA CULTIVO" , cultivationArea);
    	cultivoJSON.put("RENDIMIENTO CULTIVO" , performance);
    	try (FileWriter file = new FileWriter (filePath)){
    		file.write(cultivoJSON.toJSONString ());
    		file.write("\n");
    		System.out.println(" ### DATOS GUARDADOS EN JSON ###");		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
   // *************LECTURA ARCHIVOS JSON *****************
    public void leerJSON() {
        String filePath = "cultivo.json";
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonCultivo = (JSONObject) parser.parse(new FileReader(filePath));
            System.out.println("Nombre del cultivo: " + jsonCultivo.get("NOMBRE CULTIVO"));
            System.out.println("Tipo de cultivo: " + jsonCultivo.get("TIPO CULTIVO"));
            System.out.println("Clase de producción del cultivo: " + jsonCultivo.get("CLASE PRODUCCION CULTIVO"));
            System.out.println("Area del cultivo: " + jsonCultivo.get("AREA CULTIVO"));
            System.out.println("Rendimiento del cultivo: " + jsonCultivo.get("RENDIMIENTO CULTIVO"));
            System.out.println("DATOS DESDE ARCHIVO JSON");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
