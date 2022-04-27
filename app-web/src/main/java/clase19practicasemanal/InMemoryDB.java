package clase19practicasemanal;
/*
Hola chicos, buenas noches.
Tal como les comenté en clases, les dejo el enunciado del ejercicio semanal.
Crear un branch con el nombre practica-adicional-semana6
- Tomar como base la clase19, donde creamos una clase InMemoryDB
- crear una exception por cada operación que realiza la base de datos.
- modificar la interface IAction para poder lanzar dichas exceptions
- modificar la clase MainMap para controlar e informar los errores.
*/
import java.util.HashMap;
import java.util.Map;

import clase7.Articulo;

public class InMemoryDB {

	static private Map<Long,Articulo> db = new HashMap<>();
	
	public static void save(Long key,Articulo valor){
		InMemoryDB.db.put(key, valor);
	}
	
	public static void update(Long key, Articulo newValue) {
		InMemoryDB.db.replace(key,newValue);
	}
	
	public static void delete(Long key) {
		InMemoryDB.db.remove(key);
	}
	
	public static Articulo getById(Long key) {
		Articulo value = null;
		if(InMemoryDB.db.containsKey(key)) {
			value = InMemoryDB.db.get(key);
		}
		return value;
	}

	public static void listAll() {
		System.out.println(InMemoryDB.db.values());		
	}
}
