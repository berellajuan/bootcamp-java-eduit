package ar.com.educacionit.services.impl;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.impl.CategoriasDaoMysqlImpl;
import ar.com.educacionit.services.CategoriasService;

public class CategoriasServiceImpl extends AbstractBaseService<Categorias> implements CategoriasService {
	
	
	public CategoriasServiceImpl(){
		super(new CategoriasDaoMysqlImpl());
	}
	

}
 