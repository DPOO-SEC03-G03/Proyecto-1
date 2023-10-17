package modelo;
import modelo.AdminGeneral;
import modelo.AdminLocal;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Categoria;
import modelo.Vehiculo;
import modelo.Reserva;

import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;

public class Empresa {
	
	private HashMap<String, UsuarioGenerico> usuarios = new HashMap<>();
	private HashMap<String, Cliente> clientes = new HashMap<>();
	private List<Empleado> empleados = new ArrayList<>();
	private List<AdminLocal> adminsLocales = new ArrayList<>();
	private AdminGeneral adminGeneral;
	private HashMap<String, Sede> sedes = new HashMap<>();
	private HashMap<String, Categoria> categorias = new HashMap<>();
	private HashMap<String, Seguro> seguros = new HashMap<>();
	


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
    public void registrarSede(String nombre, String ubicacion, String horarios)
	{
		Sede nuevaSede = new Sede(nombre, ubicacion, horarios);
		anadirSede(nuevaSede);
	}
    public void anadirSede(Sede sede)
    {
    	
    }

    public void cargarUsuarios() {
        Path path = Paths.get("Proyecto-1/Entrega 3/proyecto1/data/usuarios.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            // AdminGeneral
            String[] adminGeneralInfo = lines.get(0).split("&");
            for (String info : adminGeneralInfo) {
                String[] details = info.split(";");
                AdminGeneral admin = new AdminGeneral("Admin General", details[0], details[1], details[2]);
                usuarios.put(details[1],admin);
                adminGeneral =  admin;
            }

            // AdminLocal
            String[] adminLocalInfo = lines.get(1).split("&");
            for (String info : adminLocalInfo) {
                String[] details = info.split(";");
                AdminLocal admin = new AdminLocal("Admin Local", details[0], details[1], details[2]);
                usuarios.put(details[1],admin);
                adminsLocales.add(admin);
            }

            // Empleado
            String[] empleadoInfo = lines.get(2).split("&");
            for (String info : empleadoInfo) {
                String[] details = info.split(";"); 
                Empleado nuevoEmpleado = new Empleado(details[0], details[1], details[2], details[3]);
                usuarios.put(details[1], nuevoEmpleado);
                empleados.add(nuevoEmpleado);
                Sede sedeEmpleado = sedes.get(details[4]);
                sedeEmpleado.anadirEmpleado(nuevoEmpleado);
            }

            // Cliente
            String[] clienteInfo = lines.get(3).split("&");
            for (String info : clienteInfo) {
                String[] details = info.split(";");
                usuarios.put(details[1],new Cliente(details[0], details[1], details[2], details[3], details[4], details[5],
                        details[6], details[7], details[8], details[9], details[10], details[11], details[12],
                        details[13], details[14], details[15], details[16]));
                clientes.put(details[1],new Cliente(details[0], details[1], details[2], details[3], details[4], details[5],
                        details[6], details[7], details[8], details[9], details[10], details[11], details[12],
                        details[13], details[14], details[15], details[16]));
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
                Categoria currentCategoria = new Categoria(parts[0],Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
                String[] carros = parts[5].split("&");
                for (String carro : carros) {
                    String[] details = carro.split(";");
                    Vehiculo currentCarro = new Vehiculo(details[0], details[1], details[2], details[3], details[4], Integer.parseInt(details[5]), Boolean.parseBoolean(details[6]), details[7], details[8]);
                    currentCategoria.anadirCarro(currentCarro);
                }
                categorias.put(parts[0], currentCategoria);
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
                    sedes.put(details[0],new Sede(details[0], details[1], details[2]));
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
			for (String line: lines)
			{
				String[] info = line.split(";");
				Reserva laReserva = new Reserva(clientes.get(info[0]), info[1], info[2], categorias.get(info[3]), seguros.get(info[4]), sedes.get(info[5]), sedes.get(info[6]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
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
                seguros.put(nombre, seguro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String guardarInfoUsuarios()
    {
    	
    	String end = "";
    	//Admin General
    	end = end + adminGeneral.getType()+";"+adminGeneral.getLogin()+";"+adminGeneral.getPassword()+";"+adminGeneral.getNombre()+"\n";
    	// admins locales
    	for (AdminLocal admin: adminsLocales )
    	{
    		end = end + admin.getType()+";"+admin.getLogin()+";"+admin.getPassword()+";"+admin.getNombre()+"&";
    	}
    	end = end +"\n";
    	// Empleados
    	for (Empleado empleado:empleados)
    	{
    		end = end + empleado.getType()+";"+empleado.getLogin()+";"+empleado.getPassword()+";"+empleado.getNombre()+";"+empleado.getSede()+"&";
    	}
    	end = end +"\n";
    	//Clientes
    	List<Cliente> listaClientes = new ArrayList<>();
    	for (String key: clientes.keySet())
    	{
    		listaClientes.add(clientes.get(key));
    	}
    	for (Cliente cliente: listaClientes)
    	{
    		end = end + cliente.getType()+";"+cliente.getLogin()+";"+cliente.getPassword()+";"+cliente.getNombre()+";"+cliente.getNumeroCelular() +";"+cliente.getEmail()+";"+cliente.getFechaNacimiento()+";"+cliente.getNacionalidad()+";"+cliente.getImagenDoc()+";" +cliente.getNacionalidad()+";"+cliente.getDatosLicencia().getFechaVencimiento()+";"+cliente.getDatosLicencia().getId() +";"+cliente.getDatosLicencia().getCategoria()+";"+cliente.getDatosLicencia().getImagenLicencia()+";"+cliente.getDatosPago().getTipo()+";"+cliente.getDatosPago().getNumeroTarjeta()+";"+cliente.getDatosPago().getFechaVencimiento()+"&";
    	}
    	return end;
    	
    }

    public void guardarInformacion() throws IOException {
    	File path = new File("./data/usuarios.txt");
		FileWriter writer = new FileWriter(path);
		writer.write(guardarInfoUsuarios());
		writer.flush();
		writer.close();
    	
    }

}

