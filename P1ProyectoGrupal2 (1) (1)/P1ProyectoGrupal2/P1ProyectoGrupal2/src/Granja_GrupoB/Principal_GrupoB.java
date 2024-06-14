package Granja_GrupoB;

public abstract class Principal_GrupoB {
	//******* METODOS STATIC ********
    public static void main(String[] args) {
        Empleados_GrupoB empleados = new Empleados_GrupoB("", "", "");
        empleados.datoEmpleado(empleados);
        MenuArchivo archi = new MenuArchivo (0);
        archi.archivos();

    }
}
