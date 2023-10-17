package modelo;

public class AdminGeneral extends UsuarioGenerico {
	private Empresa empresa;
	public AdminGeneral(Empresa laEmpresa,String elTypeUsuario, String elLogin, String laPass, String elNombre )
	{
		type = elTypeUsuario;
		login = elLogin;
		password = laPass;
		nombre = elNombre;
		empresa = laEmpresa;
	}
	public void registrarVehiculo(Categoria categoria,String laPlaca, String laMarca, String elModelo, String elColor, String laTransmision, int laCapacidad, boolean elEstado, String laDescEstado, String laSede)
	{
		categoria.anadirCarro(new Vehiculo(laPlaca,laMarca, elModelo, elColor, laTransmision, laCapacidad, elEstado, laDescEstado, laSede));
	}
	public void darVehiculoDeBaja(Vehiculo vehiculo)
	{
		vehiculo.cambiarEstado(false, "Dado de baja");
	}
	public void registrarSede(String nombre, String ubicacion, String horarios)
	{
		Sede nuevaSede = new Sede(nombre, ubicacion, horarios);
		empresa.anadirSede(nuevaSede);
	}
	public void cambiarNombreSede(Sede sede, String nuevoNombre)
	{
		sede.setNombre(nuevoNombre);
	}
	public void cambiarUbicacionSede(Sede sede, String nuevaUbicacion)
	{
		sede.setUbicacion(nuevaUbicacion);
	}
	public void cambiarHorariosSede(Sede sede, String nuevoHorario)
	{
		sede.setHorarios(nuevoHorario);
	}
	public void registrarEmpleado(Sede sede, String elTypeUsuario, String elLogin, String laPass, String elNombre )
	{
		Empleado nuevoEmpleado = new Empleado(elTypeUsuario, elLogin, laPass, elNombre);
		sede.anadirEmpleado(nuevoEmpleado);
	}
}
