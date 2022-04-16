package practicasemana5;

public class MainVectores {

	public static void main(String[] args) {
		System.out.println("------------------ Prueba de Integer ----------------------");
		Integer[] testInt= {2,3,4,9};
		
		CollectionCustom<Integer> entero = new CollectionCustom<>(testInt);
		
		System.out.println("Tamaño del vector: "+entero.size());
		System.out.println("Esta vacio?:  "+entero.empty());
		System.out.println("Agregar Primero el: " + 71);
		entero.addFrist(71);
		System.out.println("Agregar al Final el: " + 69);
		entero.addLast(69);
		System.out.println("Tamaño del vector: "+entero.size());
		System.out.println("Vector: "+entero);
		System.out.println("Borrar el: "+entero.remove(71));
		System.out.println("Vector: "+entero);
		System.out.println("Remover todo el vector");
		entero.removeAll();
		System.out.println("es Vacio? "+entero.empty());
		
		//------------------------------------------- test Strings
		System.out.println("------------------ Prueba de String ----------------------");
		String[] testString= {"Juan","Pedro","Jose","Ricardo"};		
		CollectionCustom<String> strings = new CollectionCustom<>(testString);
		System.out.println("Tamaño del vector: "+strings.size());
		System.out.println("Esta vacio?:  "+strings.empty());
		System.out.println("Agregar Primero el: " + "Messi");
		strings.addFrist("Messi");
		System.out.println("Agregar al Final el: " + "Ronaldo");
		strings.addLast("Ronaldo");
		System.out.println("Tamaño del vector: "+strings.size());
		System.out.println("Vector: "+strings);
		System.out.println("Borrar el: "+strings.remove("Jose"));
		System.out.println("Vector: "+strings);
		System.out.println("Remover todo el vector");
		strings.removeAll();
		System.out.println("es Vacio? "+strings.empty());

		
		
		
	}

}
