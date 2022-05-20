package ar.com.educacionit.web.controller;

import java.util.Scanner;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class CrearArticuloController {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese los datos del articulo");
		
		System.out.println("Precio: ");
		Double precio = teclado.nextDouble();
		System.out.println("Titulo: ");
		String titulo = teclado.next();
		System.out.println("Codigo: ");
		String codigo = teclado.next();
		System.out.println("Stock: ");
		Long stock = teclado.nextLong();
		
		System.out.println("Categoria: ");
		Long categoriaId = teclado.nextLong();
		
		System.out.println("Marca: ");
		Long marcasId = teclado.nextLong();

		teclado.close();
		
		Articulo nuevo = new Articulo(titulo, codigo, null, precio, stock, marcasId, categoriaId);
		
		ArticulosService artService = new ArticuloServiceImpl();
		
		try {
			artService.create(nuevo);
		} catch (ServiceException e) {
			
			System.out.println((e.getMessage() + "," + e.getCause().getMessage()));
			System.out.println("Existe actualizando...");
			try {
				Articulo artExist = artService.getByCodigo(nuevo.getCodigo());
				
				//act art en bd con los nuevos
				artExist.setCategoriasId(nuevo.getCategoriasId());
				artExist.setMarcasId(nuevo.getMarcasId());
				artExist.setPrecio(nuevo.getPrecio());
				artExist.setStock(nuevo.getStock() + artExist.getStock());
				artExist.setTitulo(nuevo.getTitulo());
				System.out.println(artExist.getTitulo());

				
				artService.update(artExist);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage() + ", "+e.getCause());
			}

		}

	}

}
