package modelo;
import java.util.List;
import java.util.ArrayList;

import modelo.Vehiculo;
import modelo.Categoria;

public class Sede {
    private String nombre;
    private String ubicacion;
    private String horarios;
    private List<Empleado> empleados;

    // Constructor
    public Sede(String nombre, String ubicacion, String horarios) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horarios = horarios;
        empleados = new ArrayList<>();
    }
    public void anadirEmpleado(Empleado empleado)
    {
    	empleados.add(empleado);
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
    
    public ArrayList<Vehiculo> getCarrosSede(List<Categoria> categorias)
    {
    	ArrayList<Vehiculo> carros = new ArrayList<>();
    	for (Categoria categoria : categorias)
    	{
    		List<Vehiculo> carrosCategoria = categoria.getCarros();
    		for (Vehiculo carro : carrosCategoria)
    		{
    			if (carro.getSede() == this.nombre)
    			{
    				carros.add(carro);
    			}
    		}
    	}
    	return carros;
    }
}
