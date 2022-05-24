package ar.com.educacionit.web.controller;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class UpdateArticuloController {
	public static void main(String[] args) throws ServiceException {	
		
		ArticulosService artService = new ArticuloServiceImpl();
		Articulo articulo = artService.getByCodigo("1asfe6");
		
		articulo.setPrecio(300d);
		
		artService.update(articulo);
		
	}

}
