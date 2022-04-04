package practicasemana4;

public class Helicoptero extends Volador implements Aterrizable{
	private Float alturaMaximaVuelo;
	
	public Helicoptero(String nombre, Float alturaMaximaVuelo) {
		super(nombre);
		this.alturaMaximaVuelo = alturaMaximaVuelo;
	}

	public Float getAlturaMaximaVuelo() {
		return alturaMaximaVuelo;
	}

	@Override
	public void aterrizar() {
		System.out.println("Aterrizando de forma segura en el helipuerto desde una altura de: " + getAlturaMaximaVuelo() );
		
	}

	

}
