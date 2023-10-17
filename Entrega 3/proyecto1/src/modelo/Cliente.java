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
	
	public Cliente(String elTypeUsuario, String elLogin, String laPass, String elNombre ,String elNumero, String elEmail, String laFechaNac, String laNacionalidad, String laImagenDoc, String elPais, String laFechaLic, String elId, String laCategoria, String laImagen, String elTipo, String elNumeroTarj, String laFechaPag)
	{
		type = elTypeUsuario;
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

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public String getEmail() {
		return email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getImagenDoc() {
		return imagenDocIdentidad;
	}

	public DatosLicencia getDatosLicencia() {
		return datosLicencia;
	}

	public DatosMediosPago getDatosPago() {
		return datosPago;
	}
	
}
