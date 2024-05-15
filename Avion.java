// Clase Avion
public class Avion {
    // Atributos
    private String model;
    private int passengerCapacity;
    private double maxSpeed;
    
    // Constructor
    public Avion(String model, int passengerCapacity, double maxSpeed) {
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.maxSpeed = maxSpeed;
    }
    
    // Métodos de acceso (getters y setters)
    public String getmodel() {
        return model;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public int getpassengerCapacity() {
        return passengerCapacity;
    }

    public void setpassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getmaxSpeed() {
        return maxSpeed;
    }

    public void setmaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    // Método para mostrar información del avión
    public void mostrarInformacion() {
        System.out.println("Modelo: " + model);
        System.out.println("Capacidad de pasajeros: " + passengerCapacity);
        System.out.println("Velocidad máxima: " + maxSpeed + " km/h");
    }

    public static void main(String[] args) {
        // Crear un objeto Avion
        Avion avion = new Avion("Boeing 747", 900, 920.0);
        
        // Mostrar información del avión
        avion.mostrarInformacion();
    }
}
