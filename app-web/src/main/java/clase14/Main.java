package clase14;

public class Main {
	public static void main(String[] args) {
		Persona carlos = new Persona("Carlos",new Espanol());
		
		carlos.decir("Hola");
		
		carlos.aprenderIdioma(new Ingles());
		
		carlos.decir("hola", new Italiano());
		
		carlos.decirEnTodos("algo");
	}
}
