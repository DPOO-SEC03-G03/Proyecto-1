package modelo;

import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private List<UsuarioGenerico> usuarios = new ArrayList<>();
	private List<Sede> sedes = new ArrayList<>();
	private List<Vehiculo> vehiculos = new ArrayList<>();
	private List<Seguro> seguros = new ArrayList<>();



    // Atributos
    private String nombre;
    private String ubicacion;
    private String horariosAtencion;

    // Constructor
    public Empresa(String nombre, String ubicacion, String horariosAtencion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horariosAtencion = horariosAtencion;
    }

    // Métodos para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getHorariosAtencion() {
        return horariosAtencion;
    }

    // Métodos para modificar los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setHorariosAtencion(String horariosAtencion) {
        this.horariosAtencion = horariosAtencion;
    }

    // Métodos adicionales
    public void iniciarReserva() {
        // Código para iniciar una reserva
    }

    public void cargarInformacion() {
        // Código para cargar información
    }

    public void cargarUsuarios() {
        Path path = Paths.get("Proyecto-1/Entrega 3/proyecto1/data/usuarios.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            // AdminGeneral
            String[] adminGeneralInfo = lines.get(0).split("&");
            for (String info : adminGeneralInfo) {
                String[] details = info.split(";");
                usuarios.add(new AdminGeneral(details[0], details[1], details[2]));
            }

            // AdminLocal
            String[] adminLocalInfo = lines.get(1).split("&");
            for (String info : adminLocalInfo) {
                String[] details = info.split(";");
                usuarios.add(new AdminLocal(details[0], details[1], details[2]));
            }

            // Empleado
            String[] empleadoInfo = lines.get(2).split("&");
            for (String info : empleadoInfo) {
                String[] details = info.split(";");
                usuarios.add(new Empleado(details[0], details[1], details[2]));
            }

            // Cliente
            String[] clienteInfo = lines.get(3).split("&");
            for (String info : clienteInfo) {
                String[] details = info.split(";");
                usuarios.add(new Cliente(details[0], details[1], details[2], details[3], details[4], details[5],
                        details[6], details[7], details[8], details[9], details[10], details[11], details[12],
                        details[13], details[14], details[15]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void cargarVehiculos() {
        Path path = Paths.get("Proyecto-1/Entrega 3/proyecto1/data/vehiculo.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] parts = line.split(":");
                String categoria = parts[0];
                // Puede guardar las tarifas si es necesario
                String[] vehiculosInfo = parts[3].split("&");

                for (String info : vehiculosInfo) {
                    String[] details = info.split(";");
                    boolean estado = Boolean.parseBoolean(details[7]);
                    vehiculos.add(new Vehiculo(categoria, details[0], details[1], details[2], details[3], details[4], 
                        details[5], Integer.parseInt(details[6]), estado, details[8]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarSedes() {
        Path path = Paths.get("Proyecto-1/Entrega 3/proyecto1/data/sedes.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] sedesInfo = line.split("&");
                for (String info : sedesInfo) {
                    String[] details = info.split(";");
                    sedes.add(new Sede(details[0], details[1], details[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cargarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        Path path = Paths.get("Proyecto-1/Entrega 3/proyecto1/data/reservas.txt");
        
        try {
            List<String> lines = Files.readAllLines(path);
            
            for (String line : lines) {
                String[] details = line.split(";");
                String clienteUsuario = details[0];
                String categoriaVehiculo = details[1];
                String placaVehiculo = details[2];
                boolean tieneSeguro = Boolean.parseBoolean(details[3]);
                String nombreSeguro = details[4];
                String fechaHoraRecogida = details[5];
                String fechaHoraDevolucion = details[6];
                List<ConductorAdicional> conductoresAdicionales = new ArrayList<>();

                if (details.length > 7) {
                    int numConductores = Integer.parseInt(details[7]);
                    String[] conductoresInfo = details[8].split("&");

                    for (String conductor : conductoresInfo) {
                        String[] conductorDetails = conductor.split(":");
                        ConductorAdicional conductorAdicional = new ConductorAdicional(
                            conductorDetails[0], conductorDetails[1], conductorDetails[2],
                            conductorDetails[3], conductorDetails[4], conductorDetails[5]
                        );
                        conductoresAdicionales.add(conductorAdicional);
                    }
                }
                
                Reserva reserva = new Reserva(clienteUsuario, categoriaVehiculo, placaVehiculo,
                                              tieneSeguro, nombreSeguro, fechaHoraRecogida,
                                              fechaHoraDevolucion, conductoresAdicionales);
                reservas.add(reserva);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Asignar la lista 'reservas' a la lista de reservas de la clase Empresa (si es necesario)
    }
    
    public void cargarSeguros() {
        Path path = Paths.get("Proyecto-1/Entrega 3/proyecto1/data/seguros.txt");
        
        try {
            List<String> lines = Files.readAllLines(path);
            
            for (String line : lines) {
                String[] details = line.split(";");
                String nombre = details[0];
                double tarifa = Double.parseDouble(details[1]);

                Seguro seguro = new Seguro(nombre, tarifa);
                seguros.add(seguro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void guardarInformacion() {
        // Código para guardar información
    }

    public static void main(String[] args) {
        // Ejemplo de cómo usar los métodos
        Empresa miEmpresa = new Empresa("RentCar", "Cra. 11 #82-71, Bogotá", "08:00-17:00");
        miEmpresa.iniciarReserva();
        miEmpresa.cargarInformacion();
        miEmpresa.cargarUsuarios();
        miEmpresa.cargarVehiculos();
        miEmpresa.cargarSedes();
        miEmpresa.cargarReservas();
        miEmpresa.guardarInformacion();
    }
}

