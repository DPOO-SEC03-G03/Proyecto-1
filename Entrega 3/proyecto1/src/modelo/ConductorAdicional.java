package modelo;

import modelo.DatosLicencia;

public class ConductorAdicional {
	private String nombre;
	private DatosLicencia licencia;
	
	public ConductorAdicional(String elNombre, String elPais, String laFechaLic, String elId, String laCategoria, String laImagen)
	{
		nombre = elNombre;
		licencia = new DatosLicencia(elPais, laFechaLic, elId, laCategoria, laImagen);
	}

	public String getNombre() {
		return nombre;
	}

	public DatosLicencia getLicencia() {
		return licencia;
	}
	
	
}
