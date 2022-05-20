package ar.com.educacionit.web.controller;

import java.util.List;
import java.util.Scanner;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class DeleteArticuloController {
	
	public static void main(String[] args) throws ServiceException {
		ArticulosService service = new ArticuloServiceImpl();
		
		System.out.println("Articulos existentes");
		List<Articulo> list = service.findAll();
		System.out.println(list);
		System.out.println("------------------------------");
		
		try(Scanner teclado = new Scanner(System.in);){
		
			System.out.println("Ingrese id de articulo");
			
			Long id = teclado.nextLong();
			
			service.delete(id);
		}

	}

}
