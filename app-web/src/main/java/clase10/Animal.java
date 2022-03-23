package clase10;

public class Animal {
	protected String color;
	private int edad;
	
	public Animal(String color) {
		System.out.println("Nace el Objeto");
	}
	
	
	public void hablar() {
		System.out.println("Animal Hablando");
	}
	
	//firma del metodo
	public String getColor() {
		String color;
		if(this.color == null) {
			color = "N/D";
		}else {
			color = this.color;
		}
		
		return color;
	}
	
	public void setColor(String newColor) {
		if(newColor != null) {
			this.color = newColor;
		}else {
			System.out.println("Debe informar un color");
		}
		
	}
	
	public void setEdad(Integer nuevaEdad) {
		if(nuevaEdad != null) {
			this.edad = nuevaEdad;
		}
	}
	

	

}
