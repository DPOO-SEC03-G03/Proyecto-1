package modelo;
import modelo.Vehiculo;
import java.util.List;
import java.util.ArrayList;

public class Categoria {
	private String id;
	private int tarifaAlta;
	private int tarifaBaja;
	private double extraSede;
	private double extraConductor;
	private List<Vehiculo> carros;
	
	public Categoria(String elId, int laTarifaBaja, int laTarifaAlta, double extraS, double extraC)
	{
		id = elId;
		tarifaAlta = laTarifaAlta;
		tarifaBaja = laTarifaBaja;
		extraSede = extraS;
		extraConductor = extraC;
		carros = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public int getTarifa(boolean temporadaAlta) {
		int tarifa;
		if (temporadaAlta) {tarifa = tarifaAlta;}
		else {tarifa = tarifaBaja;}
		return tarifa;
	}


	public double getExtraSede() {
		return extraSede;
	}

	public double getExtraConductor(int numConductoresExtra) {
		return extraConductor*numConductoresExtra;
	}

	public List<Vehiculo> getCarros() {
		return carros;
	}
	
	public void anadirCarro(Vehiculo carro)
	{
		carros.add(carro);
	}
	
}
