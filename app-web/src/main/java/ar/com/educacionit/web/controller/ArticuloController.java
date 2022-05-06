package ar.com.educacionit.web.controller;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class ArticuloController {
	public static void main(String[] args) {
		ArticulosService service = new ArticuloServiceImpl();
		
	
		try {
			Articulo articulo = service.getById(1L);
			System.out.println(articulo);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}
