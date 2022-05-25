package ar.com.educacionit.web.controller;

import ar.com.educacionit.daos.CategoriasDao;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.impl.CategoriasDaoMysqlImpl;

public class UpdateArticulo {
	public static void main(String[] args) {
		CategoriasDao dao = new CategoriasDaoMysqlImpl();
		//Categorias cat = new Categorias(5L,"Test 2",1);
		
		try {
			//dao.update(cat);
			dao.delete(5L);
		} catch (GenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
