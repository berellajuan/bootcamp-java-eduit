package clase17;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
	public static void main(String[] args) {
		Set<Carritos> carrito = new HashSet<Carritos>();
		Carritos c = new Carritos();
		Carritos c2 = new Carritos();
		carrito.add(c);
		carrito.add(c2);
		
		System.out.println(c.equals(c2));
		System.out.println(carrito.contains(c));
		System.out.println(carrito.contains(c2));
		
	}
}
