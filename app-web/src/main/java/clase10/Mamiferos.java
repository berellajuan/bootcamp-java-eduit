package clase10;

public class Mamiferos extends Animal{
	private Integer tiempoGestacion;
	
	public Mamiferos(String color, Integer tiempoGestacion) {
		super(color);
		this.tiempoGestacion = tiempoGestacion;
		super.getEdad();
	}
	
	
}
