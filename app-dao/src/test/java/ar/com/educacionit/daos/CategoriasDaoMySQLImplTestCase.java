package ar.com.educacionit.daos;

import java.util.List;

import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.impl.CategoriasDaoMysqlImpl;

public class CategoriasDaoMySQLImplTestCase {
	
	public static void main(String[] args) throws GenericException {
		//test when_findall_then_showlist
		CategoriasDao dao = new CategoriasDaoMysqlImpl();
		
		List<Categorias> list = dao.findAll();
		
		System.out.println(list.size() > 0);
	}

}
