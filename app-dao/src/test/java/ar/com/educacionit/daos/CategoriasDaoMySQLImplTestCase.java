package ar.com.educacionit.daos;

import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.impl.CategoriasDaoMysqlImpl;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@TestMethodOrder(OrderAnnotation.class)
public class CategoriasDaoMySQLImplTestCase {
	@Order(1)
	@Test
	public void then_initialize_then_showIt() {
		CategoriasDao catDao = new CategoriasDaoMysqlImpl();
		assertNotNull(catDao);
	}
	
	@Order(6)
	@Test	
	public void when_create_update_delete_then_noExists() throws GenericException, DuplicatedException {
		CategoriasDao catDao = new CategoriasDaoMysqlImpl();
		
		Categorias newCategoria = new Categorias(5L,"Perfumes", 1);
		
		newCategoria.setDescripcion("descripcion test");
		catDao.update(newCategoria);
		
		assertEquals("descripcion test", newCategoria.getDescripcion());
		
		catDao.delete(newCategoria.getId());
		
		Categorias catEliminada = catDao.getByPK(5L);
		
		assertNull(catEliminada);
		
	}


}
