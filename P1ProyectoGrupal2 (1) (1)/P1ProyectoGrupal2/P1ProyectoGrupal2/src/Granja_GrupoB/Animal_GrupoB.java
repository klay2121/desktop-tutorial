package Granja_GrupoB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat; //NUM A 2 DECIMALES

public   class Animal_GrupoB extends Granja_GrupoB {
    protected Scanner scanner = new Scanner(System.in);
    protected ArrayList<Animal_GrupoB> listaAnimales = new ArrayList<>(); //LISTA ANIMALES
    //PRIMITIVOS
    protected double weight;
    protected int cost, cant;

    public Animal_GrupoB(String name, String type, String productionClass, double weight, int cost, int cant) {
        super(name, type, productionClass);
        this.weight = weight;
        this.cost = cost;
        this.cant = cant;
    }

    public void agregarAnimal() {
        Animal_GrupoB nuevoAnimal = new Animal_GrupoB("", "", "", 0, 0, 0);//INSTANCIA NUEVA PARA ANIMAL
        ingresoDato(nuevoAnimal);
        do {
            System.out.println("Ingrese el peso del animal [8-100]: ");
            nuevoAnimal.weight = scanner.nextDouble();
        } while (nuevoAnimal.weight < 8 || nuevoAnimal.weight > 100);
        do {
            System.out.println("Ingrese el precio del animal [5-500]: ");
            nuevoAnimal.cost = scanner.nextInt();
        } while (nuevoAnimal.cost < 5 || nuevoAnimal.cost > 500);
        listaAnimales.add(nuevoAnimal); 
        guardarCSV(nuevoAnimal); //GUARDAR EN CSV LOS NUEVOS ANIMALES
        System.out.println("### DATOS DEL ANIMAL GUARDADOS CORRECTAMENTE EN LA LISTA ###");
    }

    public void imprimirListaAnimales() {
        if (listaAnimales.isEmpty()) {
            System.out.println("La lista de animales esta vacia.");
        } else {
            System.out.println("----Lista de Animales----");
            for (Animal_GrupoB animal : listaAnimales) {
                System.out.println("Nombre: " + animal.name);
                System.out.println("Tipo: " + animal.type);
                System.out.println("Clase de producción: " + animal.productionClass);
                System.out.println("Peso: " + animal.weight);
                System.out.println("Costo: " + animal.cost);
                System.out.println("----------------------------------");
            }
            System.out.println("### LISTA DE ANIMALES IMPRESA CORRECTAMENTE ###");
        }
    }

    public void ingresoAni() {
        do {
            System.out.print("Ingrese cuantos animales desea ingresar [1-10] ?: ");
            cant = scanner.nextInt();
        } while (cant < 1 || cant > 10);

        for (int i = 0; i < cant; i++) {
            System.out.println("Animal #" + (i + 1) + ":");
            agregarAnimal();
        }
        imprimirListaAnimales(); 
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

    public void ingresoDato(Animal_GrupoB animal) {
        scanner.nextLine(); 
        System.out.print("Ingrese el nombre del animal: ");
        animal.name = scanner.nextLine();
        System.out.print("Ingrese el tipo de animal: ");
        animal.type = scanner.nextLine();
        System.out.print("Ingrese la clase de producción: ");
        animal.productionClass = scanner.nextLine();
    }

    public void guardarCSV(Animal_GrupoB animal) {
        String filePath = "animal.csv";
        DecimalFormat df = new DecimalFormat("#.##"); 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(animal.name + "," + animal.type + "," + animal.productionClass + "," + df.format(animal.weight) + "," + animal.cost);
            writer.newLine();
            System.out.println("### DATOS GUARDADOS CORRECTAMENTE EN CSV ###");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerCSV() {
        String filePath = "animal.csv";
        listaAnimales.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String name = data[0];
                    String type = data[1];
                    String productionClass = data[2];
                    double weight = Double.parseDouble(data[3]);
                    int cost = Integer.parseInt(data[4]);
                    Animal_GrupoB animal = new Animal_GrupoB(name, type, productionClass, weight, cost, 0);
                    listaAnimales.add(animal);
                }
            }
            System.out.println("### DATOS CARGADOS CORRECTAMENTE DESDE EL CSV ###");
            imprimirListaAnimales();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void imprimirDat() {
		System.out.println("NOMBRE : " + name);
		System.out.println("TIPO: " + type);
		System.out.println("PRODUCCION: " + productionClass);
	}
}
    
