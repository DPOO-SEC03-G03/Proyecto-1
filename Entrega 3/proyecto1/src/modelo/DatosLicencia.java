package modelo;

public class DatosLicencia {
	private String paisExpedicion;
	private String fechaVencimiento;
	private String idLicencia;
	private String categoriaLicencia;
	private String imagenLicencia;
	
	public DatosLicencia(String elPais, String laFechaLic, String elId, String laCategoria, String laImagen)
	{
		paisExpedicion = elPais;
		fechaVencimiento = laFechaLic;
		idLicencia = elId;
		categoriaLicencia = laCategoria;
		imagenLicencia = laImagen;
	}

	public String getPaisExpedicion() {
		return paisExpedicion;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getIdLicencia() {
		return idLicencia;
	}

	public String getCategoriaLicencia() {
		return categoriaLicencia;
	}

	public String getImagenLicencia() {
		return imagenLicencia;
	}
	
}
