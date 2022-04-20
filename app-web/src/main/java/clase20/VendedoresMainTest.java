package clase20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class VendedoresMainTest {

	public static void main(String[] args) {

		Vendedores archivoVendedores = new Vendedores();
		Collection<Vendedor> vendedores = archivoVendedores.getVendedores();

		Ventas archivoVentas = new Ventas();
		Collection<Venta> ventas = archivoVentas.getVentas();
		
		System.out.println(ventas);
		// venta de ese vendedor
		Map<Vendedor, Collection<Venta>> mapVentasXVendedor = new HashMap<>();

		for (Vendedor vendedor : vendedores) {
			mapVentasXVendedor.put(vendedor, new ArrayList<Venta>());
		}
		// cargar para cada vendedor las ventas que tiene
		for (Vendedor vendedor : vendedores) {
			for (Venta venta : ventas) {
				if (vendedor.getId().equals(venta.getIdVendedor())) {
					//devuelve una coleccion de ventas del vendedor y le agrego una venta
					mapVentasXVendedor.get(vendedor).add(venta);
				}
			}

		}

		// TPH: investigar hashcode e equals


		System.out.println(mapVentasXVendedor);

	}

}