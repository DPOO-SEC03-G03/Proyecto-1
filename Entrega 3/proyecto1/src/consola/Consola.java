package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import modelo.Empresa;


public class Consola {
	
		Empresa empresa = null;
		
		public void ejecutarAplicacion() throws IOException
		{
			System.out.println("Bienvenido :)");

			boolean continuar = true;
			while (continuar)
			{
				try
				{
					mostrarMenu();
					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
						 if (opcion_seleccionada == 1)
						ejecutarlogin();
					else if (opcion_seleccionada == 2 && empresa != null)
						ejecutarMostrarMenu();
					else if (opcion_seleccionada == 3 && empresa != null)
						ejecutarIniciarNuevoPedido();
					else if (opcion_seleccionada == 7)
					{
						System.out.println("Saliendo de la aplicación ...");
						continuar = false;
					}
					else if (empresa == null)
					{
						System.out.println("Para poder ejecutar esta opción primero debe iniciar restaurante");
					}
					else
					{
						System.out.println("Por favor seleccione una opción válida.");
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
			}
		}

	private void ejecutarlogin() {
			// TODO Auto-generated method stub
			
		}

	private void mostrarMenu() {
		
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. login");
		
		}

	private String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		
		{
			Consola c = new Consola();
			c.ejecutarAplicacion();
		}

	}

}
