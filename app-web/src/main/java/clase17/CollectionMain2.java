package clase17;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMain2 {
	//Java collection Framework
	//Collection<E>
	// List<T>: admite elementos duplicados
	// -clases: 
	//			-ArrayList<T>
	//			-LinkedList<T>
	// Set<T>: no admite elementos duplicados
	// Map<K,V>: Clave, Valor
	
	//1- crear una collection
	
	
	//2- agregar elementos
	public static void main(String[] args) {
		Collection<String> nombres = new ArrayList<>();
		nombres.add("brenda");
		nombres.add("walter");
		nombres.add("nicolas");
		
		
		//3 tamaño
		int tamanio = nombres.size();
		System.out.println(tamanio);
		
		for (String string : nombres) {
			System.out.println(string);
		}
		
		//eliminar
		nombres.remove("walter");
		
		//eliminarTodo
		//nombres.clear();
		
		//eliminar en un ciclo
		//Iterator(): Iterator<String>
		//Iterator hasNext(): boolean
		//next():<>
		
		
		
		//tamanio
		System.out.println(nombres.size());
		
		
	}
	
	
}
