package ar.com.educacionit.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.impl.ArticuloDaoMysqlImpl;


@TestMethodOrder(OrderAnnotation.class)
public class ArticuloDaoTestCase {
	
	@Order(1)
	@Test
	public void then_initialize_then_showIt() {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		assertNotNull(art);
	}
	
	@Order(2)
	//@Test
	public void when_newArticulo_then_persistIt() throws GenericException, DuplicatedException {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		Articulo newArticulo = new Articulo("titulo", "codigo", new java.util.Date(), 1500d, 100l, 1l, 1l);
		art.save(newArticulo);
		assertNotNull(newArticulo.getId());
	}
	
	@Order(3)
	@Test
	public void when_findAll_then_listIt() throws GenericException, DuplicatedException {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		List<Articulo> arts = art.findAll();
		
		assertNotEquals(0, arts.size());
		assertEquals(5,arts.size());
	}
	
	@Order(4)
	@Test
	public void when_getOneByCode_then_showIt() throws GenericException   {
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		Articulo art = artDao.getByCodigo("codigo");
		assertEquals("codigo", art.getCodigo());
	}
	
	@Order(5)
	@Test
	public void when_exist_then_updateIt() throws GenericException, DuplicatedException {
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		
		Articulo art = artDao.getByCodigo("codigo");
		
		art.setTitulo("nuevo titulo");
		
		artDao.update(art);
		
		assertEquals("nuevo titulo", art.getTitulo());
		
	}
	
	@Order(6)
	@Test	
	public void when_create_update_delete_then_noExists() throws GenericException, DuplicatedException {
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		
		Articulo newArticulo = new Articulo("titulo", "codigotest", new java.util.Date(), 1500d, 100l, 1l, 1l);
		
		artDao.save(newArticulo);
		
		assertNotNull(newArticulo);
		
		newArticulo.setTitulo("titulo test");
		artDao.update(newArticulo);
		
		assertEquals("titulo test", newArticulo.getTitulo());
		
		artDao.delete(newArticulo.getId());
		
		Articulo artDelete = artDao.getByCodigo("codigotest");
		
		assertNull(artDelete);
		
	}
	
	//validar exceptions
	@Order(7)
	@Test
	public void when_duplicate_then_throw_exception() throws GenericException, DuplicatedException {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		
		Articulo newArticulo = new Articulo("titulo", "codigo150", new java.util.Date(), 1500d, 100l, 1l, 1l);
		
		art.save(newArticulo);
		
		assertThrows(DuplicatedException.class,() -> {
			newArticulo.setCodigo("codigo1002");
			art.save(newArticulo);
		});
		
	}

}
