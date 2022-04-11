package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class LinkedListMain5 {	
	public static void main(String[] args) {
		LinkedList<String> nombres = new LinkedList<>();
		
		nombres.add("carlos");
		nombres.add("juan");
		nombres.add("jose");
		nombres.add("maria");
		
		//Vector<String> vector = new Vector<>();
		
		nombres.addFirst("antes de carlos");
		nombres.addLast("depues de maria");
		
		for (String nombre : nombres) {
			System.out.println(nombre);
		}
	}
	
	
	
	
}
