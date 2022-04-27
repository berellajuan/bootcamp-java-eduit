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

import clase19practicasemanal.exceptions.MemoryDBCRUDException;
import clase19practicasemanal.exceptions.MemoryDBListarException;
import clase19practicasemanal.exceptions.MemoryDBModificarException;
import clase19practicasemanal.exceptions.MemoryDBSaveException;
import clase19practicasemanal.exceptions.MemoryDBUpdateException;
import clase7.Articulo;

public class InMemoryDB {

	static private Map<Long, Articulo> db = new HashMap<>();

	public static void save(Long key, Articulo valor) throws MemoryDBCRUDException {
		if (key != null && valor != null && valor instanceof Articulo) {
			InMemoryDB.db.put(key, valor);
		} else if (key == null || valor == null) {
			throw new MemoryDBCRUDException("Error al Guardar en la Base de Datos",
					new MemoryDBSaveException("La clase articulo o key son null"));
		} else if (valor instanceof Articulo) {
			throw new MemoryDBCRUDException("Error al Guardar en la Base de Datos",
					new MemoryDBSaveException("El objeto ingresado no es una instancia de Articulo"));
		}

	}

	public static void update(Long key, Articulo newValue) throws MemoryDBCRUDException {
		if (key != null && newValue != null && newValue instanceof Articulo) {
			InMemoryDB.db.replace(key, newValue);
		} else if (key == null || newValue == null) {
			throw new MemoryDBCRUDException("Error al Modificar en la Base de Datos",
					new MemoryDBUpdateException("La clase articulo o key son null"));
		} else if (newValue instanceof Articulo) {
			throw new MemoryDBCRUDException("Error al Modificar en la Base de Datos",
					new MemoryDBUpdateException("El objeto ingresado no es una instancia de Articulo"));
		}
	}

	public static void delete(Long key) throws MemoryDBCRUDException {
		if (key != null) {
			InMemoryDB.db.remove(key);
		} else if (key == null) {
			throw new MemoryDBCRUDException("Error al Borrar en la Base de Datos",
					new MemoryDBUpdateException("La key es null"));
		}
	}

	public static Articulo getById(Long key) throws MemoryDBCRUDException {
		Articulo value = null;

		if (key != null) {
			if (InMemoryDB.db.containsKey(key)) {
				value = InMemoryDB.db.get(key);
			}
		}else if(key == null){
			throw new MemoryDBCRUDException("Error al Buscar en la Base de Datos",
					new MemoryDBModificarException("La key es null"));
		}
		
		return value;
	}

	public static void listAll() {
		System.out.println(InMemoryDB.db.values());

		
	}
}
