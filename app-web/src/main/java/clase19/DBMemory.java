package clase19;

import java.util.Map;

public class DBMemory {
	private String id;
	private Integer edad;
	
	public String getId() {
		return id;
	}

	public Integer getEdad() {
		return edad;
	}

	static private Map<String, String> db;
	
	static public void save(String clave, String valor) {
		DBMemory.db.put(clave, valor);
	}
	static public void update(String key, String newValue) {
		DBMemory.db.replace(key, newValue);
	}
	static public void delete(String key) {
		DBMemory.db.remove(key);
	}
	static public String getById(String key) {
		String value=null;
		if(DBMemory.db.containsKey(key)) {
			value = DBMemory.db.get(key);
		}
		return value;
	}
}
