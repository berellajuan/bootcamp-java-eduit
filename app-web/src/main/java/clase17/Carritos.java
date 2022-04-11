package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Carritos {

	private List<String> items;
	
	public Carritos() {
		items = new ArrayList<String>();
	}
	public void agregar(String item) {
		items.add(item);
	}

}
