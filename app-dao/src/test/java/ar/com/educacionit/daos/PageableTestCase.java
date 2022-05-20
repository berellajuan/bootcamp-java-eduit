package ar.com.educacionit.daos;

import java.util.List;

import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.impl.CategoriasDaoMysqlImpl;

public class PageableTestCase {
	//when_paginate_then_showlist
	public static void main(String[] args) throws GenericException {
		CategoriasDao dao = new CategoriasDaoMysqlImpl();
		
		List<Categorias> list = dao.findPageable(1,2);
		
		System.out.println(list);
		
		
		ArticuloDao dao2 = new ArticuloDaoMysqlImpl();
		
		List<Articulo> list2 = dao2.findPageable(1,2);
		
		System.out.println(list2);
	}
	
	
}
