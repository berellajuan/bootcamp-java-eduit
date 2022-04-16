package clase19;

import java.util.Map;

public class AccionMap{
	static Map<Integer, IAccion> mapAcciones = construirAcciones();
	
	private static Map<Integer, IAccion> construirAcciones() {
		// cargo el mapa
		mapAcciones.put(1, new AccionAlta());
		mapAcciones.put(2, new AccionBaja());
		mapAcciones.put(3, new AccionModif());
		mapAcciones.put(4, new AccionListar());
		mapAcciones.put(5, new AccionDefault());
		return mapAcciones;
	}

	public IAccion getAccion(Integer op) {
		IAccion accion;
		if(mapAcciones.containsKey(op)) {
			accion = mapAcciones.get(op);
		}else {
			accion= mapAcciones.get(5);
		}
		return accion;
		
	}

	

	
}
