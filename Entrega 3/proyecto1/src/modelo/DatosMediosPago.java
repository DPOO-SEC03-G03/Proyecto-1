package modelo;

public class DatosMediosPago {
	private String tipo;
	private String numeroTarjeta;
	private String fechaVencimiento;
	
	public DatosMediosPago(String elTipo, String elNumeroTarj, String laFechaPag)
	{
		tipo = elTipo;
		numeroTarjeta = elNumeroTarj;
		fechaVencimiento = laFechaPag;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	
}
