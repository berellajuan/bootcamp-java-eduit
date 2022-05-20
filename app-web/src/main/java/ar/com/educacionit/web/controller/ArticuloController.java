package ar.com.educacionit.web.controller;

import java.util.List;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;

public class ArticuloController {
	public static void main(String[] args) {
		//necesito el service
				ArticulosService service = new ArticuloServiceImpl();
				
				//TODO implementar un menu de acciones
				try {
					List<Articulo> articulos = service.findAll();
					
					System.out.println(articulos);
					if(!articulos.isEmpty()) {
						Articulo articulo =  service.getById(articulos.get(0).getId());
						
						System.out.println(articulo);
						
						//QUIERO ELIMINAR 
						//service.deleteArticulo(articulo.getId());//ctrl+t
						
						//System.out.println("se ha eliminado" + articulo.getId());
						
						articulo.setStock(25l);
						articulo.setPrecio(100000d);
						
						service.update(articulo);
					}
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				
				/* dao > CRUD ok 
				 * daoimpl > 
				 * service
				 * controller
				 * */
		
	}
}
