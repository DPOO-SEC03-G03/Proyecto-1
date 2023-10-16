package modelo;

public class Sede {
    private String nombre;
    private String ubicacion;
    private String horarios;

    // Constructor
    public Sede(String nombre, String ubicacion, String horarios) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horarios = horarios;
    }

    // Métodos para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getHorarios() {
        return horarios;
    }

    // Métodos para modificar los atributos (si es necesario)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public static void main(String[] args) {
        // Crear instancias de las sedes
        Sede bogota = new Sede("Bogotá", "Cra. 11 #82-71", "08:00-17:00");
        Sede cartagena = new Sede("Cartagena", "Cra. 8 #28-36", "08:00-17:00");
        Sede medellin = new Sede("Medellín", "Cra. 13 #73-57", "08:00-17:00");

        // Imprimir información de las sedes

    }
}

