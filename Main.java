/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cajero2;

/**
 *
 * @author KLAY
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Usuario {
    private String nombre;
    private String id;
    private String password;
    private double balance;

    public Usuario(String nombre, String id, String password, double balance) {
        this.nombre = nombre;
        this.id = id;
        this.password = password;
        this.balance = balance;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public boolean verificarPassword(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0 || cantidad > 100) {
            this.balance += cantidad;
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && this.balance >= cantidad) {
            this.balance -= cantidad;
            return true;
        }
        return false;
    }
}

class Sistema {
    private Map<String, Usuario> usuarios;

    public Sistema() {
        usuarios = new HashMap<>();
    }

    public void registrarUsuario(String nombre, String id, String password, double balance) {
        if (!usuarios.containsKey(id)) {
            usuarios.put(id, new Usuario(nombre, id, password, balance));
        }
    }

    public Usuario autenticarUsuario(String id, String password) {
        Usuario usuario = usuarios.get(id);
        if (usuario != null && usuario.verificarPassword(password)) {
            return usuario;
        }
        return null;
    }

    public Usuario obtenerUsuario(String id) {
        return usuarios.get(id);
    }
}

class Cajero {
    private Sistema sistema;

    public Cajero(Sistema sistema) {
        this.sistema = sistema;
    }

    public void iniciarSesion(String id, String password) {
        Usuario usuario = sistema.autenticarUsuario(id, password);
        if (usuario != null) {
            System.out.println("Bienvenido " + usuario.getNombre());
            mostrarOpciones(usuario);
        } else {
            System.out.println("ID o contrasenia incorrectos.");
        }
    }

    private void mostrarOpciones(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Consultar balance");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarBalance(usuario);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDepositar = scanner.nextDouble();
                    depositar(usuario, cantidadDepositar);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetirar = scanner.nextDouble();
                    retirar(usuario, cantidadRetirar);
                    break;
                case 4:
                    System.out.println("Gracias por usar el cajero.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
        scanner.close();
    }

    public void consultarBalance(Usuario usuario) {
        System.out.println("Su balance es: " + usuario.getBalance());
    }

    public void depositar(Usuario usuario, double cantidad) {
        usuario.depositar(cantidad);
        System.out.println("Deposito exitoso. Su nuevo balance es: " + usuario.getBalance());
    }

    public void retirar(Usuario usuario, double cantidad) {
        if (usuario.retirar(cantidad)) {
            System.out.println("Retiro exitoso. Su nuevo balance es: " + usuario.getBalance());
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Sistema sistema = new Sistema();

        // Solicitar datos dinámicos para registro de usuario
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su ID de usuario: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese su contrasenia: ");
        String password = scanner.nextLine();

        double balanceInicial = 1000.0; // Puede ser solicitado también si se desea

        sistema.registrarUsuario(nombre, id, password, balanceInicial);

        // Solicitar datos para iniciar sesión
        System.out.print("Ingrese su ID de usuario para iniciar sesion: ");
        String idLogin = scanner.nextLine();

        System.out.print("Ingrese su contrasenia para iniciar sesion: ");
        String passwordLogin = scanner.nextLine();
      
        Cajero cajero = new Cajero(sistema);
        cajero.iniciarSesion(idLogin, passwordLogin);
        scanner.close();
    }
}
