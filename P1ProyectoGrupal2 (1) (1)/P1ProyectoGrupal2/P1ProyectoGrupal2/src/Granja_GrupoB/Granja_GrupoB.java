package Granja_GrupoB;
import java.util.Scanner;

public abstract class Granja_GrupoB {
	protected Scanner scanner = new Scanner (System.in);
	//ATRIBUTOS- PREFERENCIADOS
	protected String name, type, productionClass;
	
	public Granja_GrupoB (String name, String type, String productionClass) {
		//CONSTRUCTOR
		this.name = name;
		this.type = type;
		this.productionClass = productionClass;
	}
	//INGRESAMOS DATOS
	public void  ingresoDato () {
		System.out.println("Ingrese el nombre: ");
		name = scanner.nextLine();
		System.out.println("Ingrese el tipo : ");
		type = scanner.nextLine();
		System.out.println("Ingrese el tipo de produccion: ");
		productionClass = scanner.nextLine();
	}
	//***************POLIMORFISMO_IMPRIMIR DATOS**************
	public abstract void imprimirDat ();
}
