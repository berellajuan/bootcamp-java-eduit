package practicasemana4;

public class Ovni extends Volador {
	
	private Integer cantidadAbducciones;
	
	public Ovni(String nombre, Integer cantidadAbducciones) {
		super("Objeto Volador No Identificado");
		this.cantidadAbducciones = cantidadAbducciones;
	}

	public Integer getCantidadAbducciones() {
		return cantidadAbducciones;
	}

}
