package modelo;
import modelo.Sede;
import java.util.List;
import java.util.ArrayList;

public class Empleado extends UsuarioGenerico {
	private Sede sede;
	public Empleado(String elTypeUsuario, String elLogin, String laPass, String elNombre )
	{
		type = elTypeUsuario;
		login = elLogin;
		password = laPass;
		nombre = elNombre;
	}
	public void cambiarEstadoVehiculo(List<Categoria> categorias, int numCarro, boolean nuevoEstado, String nuevaDescEstado)
	{
		List<Vehiculo> carros = sede.getCarrosSede(categorias);
		Vehiculo carroACambiar = carros.get(numCarro);
		carroACambiar.cambiarEstado(nuevoEstado, nuevaDescEstado);
	}
	
	public String mostrarCarrosSede(List<Categoria> categorias)
	{
		List<Vehiculo> carros = sede.getCarrosSede(categorias);
		String listado = "";
		int numeroCarro = 0;
		for (Vehiculo carro: carros)
		{
			listado = listado + Integer.toString(numeroCarro) + carro.toString() +"\n";
		}
		return listado;
	}
	
	public void setSede(Sede laSede)
	{
		sede = laSede;
	}
}
