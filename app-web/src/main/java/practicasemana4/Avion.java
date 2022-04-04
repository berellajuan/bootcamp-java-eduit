package practicasemana4;

public class Avion extends Volador implements Aterrizable{

	private Integer capacidadMaxima;
	
	public Avion(String nombre, Integer capacidad) {
		super(nombre);
		this.capacidadMaxima = capacidad;
	}

	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}

	@Override
	public void aterrizar() {
		System.out.println("Aterrizando... sin problemas en la pista");
		
	}
	
	

}
