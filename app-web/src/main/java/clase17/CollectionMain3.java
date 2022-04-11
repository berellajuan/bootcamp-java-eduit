package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionMain3 {
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
		/*
		nombres.add("brenda");
		nombres.add("walter");
		nombres.add("nicolas");
		*/
		
		nombres = new LinkedList<>();
		
		//collection<T>
		// List<T>
			// ArrayList<T>
			// LinkedList<T>
		// Set<T>
		 	//-HashSet<T>
			//-TreeSet<T>
		
		nombres = new HashSet<String>();
		nombres = new LinkedList<String>();
		
		
	}
	
	
}
