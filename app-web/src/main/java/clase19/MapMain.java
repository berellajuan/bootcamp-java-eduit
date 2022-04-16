package clase19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapMain {
	public static void main(String[] args) {
		/*
		 Asociar dias semana
		 1-lunes
		 2-martes
		 3-etc 
		*/
		Map<Integer, String> mapSemana = new HashMap<>();
		
		//cargar un valor al mapa
		
		mapSemana.put(1, "Lunes");
		mapSemana.put(2, "Martes");
		mapSemana.put(3, "Miercoles");
		mapSemana.put(4, "Jueves");
		mapSemana.put(5, "Viernes");
		mapSemana.put(6, "Sabado");
		mapSemana.put(7, "Domingo");
		
		System.out.println(mapSemana);
		
		//determinar si existe una clave dentro del mapa
		System.out.println("Existe ? : " +mapSemana.containsKey(8));
		
		//eliminar un clave-valor
		
		System.out.println(mapSemana.remove(3));
		//-elimina miercoles
		
		System.out.println(mapSemana);
		
		//vaciar mapa
		//mapSemana.clear();
		//System.out.println(mapSemana);
		
		//las clave son unicas
		mapSemana.put(5, "Valor nuevo");
		System.out.println(mapSemana);
		
		//obetener las claves del mapa
		Set<Integer> keys =  mapSemana.keySet();
		System.out.println("Claves del mapa: " + keys);

		//recorrer el mapa usando sus claves
		for(Integer oneKey: keys) {
			System.out.println("key: " + oneKey + " Value: " +mapSemana.get(oneKey));
		}
		
		//MapEntry<K,K> -> Recorre el mapa de a pares
		 Set<Map.Entry<Integer, String>> entrySet = mapSemana.entrySet(); // devuelve set de entry
		 
		 //como reccorer las en entradas de un mapa usando entryset
		 for(Map.Entry<Integer, String> oneEntry: entrySet) {
			 Integer oneKey = oneEntry.getKey();
			 String oneValue = oneEntry.getValue();
			 System.out.println(oneKey + " - " + oneValue);
		 }
		 
		 //LinkedHashMap<K,V> -> Mantiene un orden

	}
	
	
}
