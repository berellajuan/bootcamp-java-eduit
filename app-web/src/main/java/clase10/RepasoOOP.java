package clase10;

import java.util.Scanner;

public class RepasoOOP {

	public static void main(String[] args) {
		Animal perro = new Animal("Rojo");
		
		perro.hablar();
		
		System.out.println(perro.getColor());
		
		perro.setColor("Negro");
		
		System.out.println(perro.getColor());
		
		Scanner teclado = new Scanner(System.in);
		Integer edad;
		do {
			System.out.println("Ingrese edad del animal");
			edad = teclado.nextInt();
		}while(edad==null);
		
		
		perro.setEdad(edad);
	}

}
