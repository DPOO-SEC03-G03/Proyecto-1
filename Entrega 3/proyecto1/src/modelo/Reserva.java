package modelo;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import modelo.Seguro;

public class Reserva {
	private Cliente cliente;
	private String fechaHoraDevolucion;
	private String fechaRangoRecogida;
	private Categoria categoria;
	private Seguro seguro;
	private Vehiculo vehiculoSeleccionado;
	private Sede sedeRecogida;
	private Sede sedeDevolucion;
	private List<ConductorAdicional> conductoresAdicionales;
	
	public Reserva(Cliente elCliente, String laFechaHoraLlegada, String laFechaRangoRecogida, Categoria laCategoria, Seguro elSeguro, Sede sedeR, Sede sedeD)
	{
		cliente = elCliente;
		fechaHoraDevolucion = laFechaHoraLlegada;
		fechaRangoRecogida = laFechaRangoRecogida;
		categoria = laCategoria;
		seguro = elSeguro;
		sedeRecogida = sedeR;
		sedeDevolucion = sedeD;
		vehiculoSeleccionado = seleccionarVehiculo();
		conductoresAdicionales = new ArrayList<>();
	}
	public Vehiculo seleccionarVehiculo()
	{
		Vehiculo vehiculo = null;
		List<Categoria> listaCat = new ArrayList<>();
		listaCat.add(categoria);
		ArrayList<Vehiculo> carros = sedeRecogida.getCarrosSede(listaCat);
		for (int i = 0; i < carros.size(); i++)
		{
			Vehiculo carroCurrent = carros.get(0);
			if (carroCurrent.getEstado()==true) {
				vehiculo = carroCurrent;
			}
		}
		vehiculo.cambiarEstado(false, "Reservado");
		return vehiculo;
	}
	public double getTarifaReserva()
	{
		return getTarifaFinal()*0.3;
	}
	public double getTarifaFinal()
	{
		double tarifa = 0.0;
		tarifa = tarifa + (seguro.getTarifaDiaria()*diasReserva());
		tarifa = tarifa + categoria.getTarifa(false)*diasReserva();
		tarifa = tarifa + categoria.getExtraConductor(conductoresAdicionales.size());
		
		return tarifa;
	}
	public double getTarifaRecogida()
	{
		return getTarifaFinal()*0.3;
	}
	public int diasReserva()
	{
		LocalDate inicio = LocalDate.parse(fechaRangoRecogida);
		LocalDate end = LocalDate.parse(fechaHoraDevolucion);
		Long daysBetween = ChronoUnit.DAYS.between(inicio, end);
		return daysBetween.intValue();
	}
	public void anadirConductor(ConductorAdicional conductor)
	{
		conductoresAdicionales.add(conductor);
	}
	public void devolverVehiculo()
	{
		vehiculoSeleccionado.cambiarEstado(true, "disponible");
		vehiculoSeleccionado.cambiarSede(sedeDevolucion.getNombre());
	}
}
