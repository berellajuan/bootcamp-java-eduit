package ar.com.educacionit.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.impl.ArticuloDaoMysqlImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ArticuloDaoMySQLImplTestCase {
	
	@Order(1)
	@Test
	public void when_newArticulo_SQL2_then_persistIt() throws GenericException, DuplicatedException {	//quiero probar el metodo save
		ArticuloDao artiDao = new ArticuloDaoMysqlImpl();
		
		Articulo newArticulo = new Articulo("titulo", "codigo001", new java.util.Date(), 1500d, 100l, 1l, 1l);
		
		artiDao.save(newArticulo);
	
		assertNotNull(newArticulo);
		
	}
	

}
