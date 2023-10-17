package modelo;

public class Vehiculo {
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String transmision;
	private String sede;
	private int capacidad;
	private boolean estado;
	private String descEstado;
	
	public Vehiculo(String laPlaca, String laMarca, String elModelo, String elColor, String laTransmision, int laCapacidad, boolean elEstado, String laDescEstado, String laSede)
	{
		placa = laPlaca;
		marca =laMarca;
		modelo = elModelo;
		color = elColor;
		transmision = laTransmision;
		sede = laSede;
		capacidad = laCapacidad;
		estado = elEstado;
		descEstado = laDescEstado;
	}
	
	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}

	public String getTransmision() {
		return transmision;
	}

	public String getSede() {
		return sede;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public boolean getEstado() {
		return estado;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void cambiarEstado(boolean nuevoEstado, String nuevaDescEstado)
	{
		this.estado = nuevoEstado;
		this.descEstado = nuevaDescEstado;
	}
	public void cambiarSede(String nuevaSede)
	{
		this.sede = nuevaSede;
	}
}
