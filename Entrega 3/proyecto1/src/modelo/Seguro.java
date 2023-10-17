package modelo;

public class Seguro {
	
    private String nombre;
    private double tarifaDiaria;

    public Seguro(String nombre, double tarifaDiaria) {
        this.nombre = nombre;
        this.tarifaDiaria = tarifaDiaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }
    
    //metodos adic
    public String getNombre0() {
        return nombre;
    }

    public double getTarifa0() {
        return tarifaDiaria;
    }

}


