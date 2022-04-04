package practicasemana4;

public class Superman extends Volador  implements Aterrizable{
	
	private String nacionalidad;
	
	public Superman(String nacionalidad) {
		super("Clark Joseph Ken");
		this.nacionalidad = nacionalidad;
	}
	

	public String getNacionalidad() {
		return nacionalidad;
	}


	@Override
	public void aterrizar() {
		System.out.println("Relizando una aterrizaje de super heroe....");
	}
	
	
	

}
