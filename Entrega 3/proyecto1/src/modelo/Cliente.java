package modelo;

import modelo.DatosLicencia;
import modelo.DatosMediosPago;

public class Cliente extends UsuarioGenerico {
	private String numeroCelular;
	private String email;
	private String fechaNacimiento;
	private String nacionalidad;
	private String imagenDocIdentidad;
	private DatosLicencia datosLicencia;
	private DatosMediosPago datosPago;
	
	public Cliente(String elLogin, String laPass, String elNombre ,String elNumero, String elEmail, String laFechaNac, String laNacionalidad, String laImagenDoc, String elPais, String laFechaLic, String elId, String laCategoria, String laImagen, String elTipo, String elNumeroTarj, String laFechaPag)
	{
		login = elLogin;
		password = laPass;
		nombre = elNombre;
		numeroCelular = elNumero;
		email = elEmail;
		fechaNacimiento = laFechaNac;
		nacionalidad = laNacionalidad;
		imagenDocIdentidad = laImagenDoc;
		datosLicencia = new DatosLicencia(elPais, laFechaLic, elId, laCategoria, laImagen);
		datosPago = new DatosMediosPago(elTipo, elNumeroTarj, laFechaPag);
	}
}
