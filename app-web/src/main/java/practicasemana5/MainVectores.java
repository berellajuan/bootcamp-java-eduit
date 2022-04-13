package practicasemana5;

public class MainVectores {

	public static void main(String[] args) {
		Integer[] testInt= {2,3,4,9};
		String[] testString= {"juan","pedro","jose"};
		CollectionCustom<Integer> entero = new CollectionCustom<>(testInt);
		
		
		System.out.println("Tamaño: "+entero.size());
		System.out.println("es Vacio? "+entero.empty());
		
		entero.addFrist(69);
		entero.addLast(69);
		
		System.out.println("Tamaño: "+entero.size());
		System.out.println("es Vacio? "+entero.empty());
		System.out.println("Vector: "+entero);
		System.out.println(entero.remove(69));
		System.out.println("Vector: "+entero);
		entero.removeAll();
		System.out.println("Vector: "+entero);

		
		
		
	}

}
