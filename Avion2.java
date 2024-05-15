// Clase Avion con abstracción funcional y de datos
public class Avion2 {
   // Interfaz para la abstracción funcional de un Avión
interface FuncionesAvion {
    void despegar();
    void aterrizar();
    void volar();
}

// Clase abstracta para la abstracción de datos de un Avión
abstract class DatosAvion {
    protected String modelo;
    protected int capacidadPasajeros;
    protected double velocidadMaxima;

    public DatosAvion(String modelo, int capacidadPasajeros, double velocidadMaxima) {
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMaxima = velocidadMaxima;
    }

    // Getters y Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    // Método abstracto para mostrar información
    public abstract void mostrarInformacion();
}

// Clase Avion que implementa la interfaz y extiende la clase abstracta
public class Avion extends DatosAvion implements FuncionesAvion {
    public Avion(String modelo, int capacidadPasajeros, double velocidadMaxima) {
        super(modelo, capacidadPasajeros, velocidadMaxima);
    }

    // Implementación de los métodos de la interfaz
    public void despegar() {
        System.out.println("El avión " + modelo + " está despegando.");
    }

    public void aterrizar() {
        System.out.println("El avión " + modelo + " está aterrizando.");
    }

    public void volar() {
        System.out.println("El avión " + modelo + " está volando.");
    }

    // Implementación del método abstracto
    public void mostrarInformacion() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidad de pasajeros: " + capacidadPasajeros);
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
    }
}

}

