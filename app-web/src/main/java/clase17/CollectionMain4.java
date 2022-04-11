package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain4 {
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
		
		Collection<String> nombres2 = new ArrayList<>();
		
		Iterator<String>  iterador= nombres.iterator();
		
		
		while(iterador.hasNext()) {
			 String nombreActual = iterador.next();
			 System.out.println("eliminando: " + nombreActual);
			 nombres2.add(nombreActual);
			 iterador.remove();
			 
		}
		
		iterador = nombres2.iterator();
		while(iterador.hasNext()){
			System.out.println(iterador.next());
		}
		
		
		//tamanio
		System.out.println(nombres.size());
		
		
	}
	
	
}
