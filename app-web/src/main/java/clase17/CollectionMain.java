package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
		Collection<String> nombres = new ArrayList<>();
		nombres.add("brenda");
		nombres.add("walter");
		nombres.add("nicolas");
	
		//eliminar de manera segura
		Iterator<String>  iterador= nombres.iterator();
		while(iterador.hasNext()) {
			 String nombreActual = iterador.next();
			 System.out.println("eliminando: " + nombreActual);
			 iterador.remove();
		}
		
		//si esta vacia
		if(nombres.isEmpty()) {
			System.out.println("Esta Vacio");
		}
	}
	
	
}
