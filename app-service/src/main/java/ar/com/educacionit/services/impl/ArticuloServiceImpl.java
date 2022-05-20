package ar.com.educacionit.services.impl;

import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticuloServiceImpl extends AbstractBaseService<Articulo> implements ArticulosService {
	
	
	public ArticuloServiceImpl(){
		super(new ArticuloDaoMysqlImpl());
	}
	

	@Override
	public Articulo getByCodigo(String codigo) throws ServiceException {
		try {
			return ((ArticuloDaoMysqlImpl)dao).getByCodigo(codigo);
		} catch (GenericException e) {
			throw new ServiceException("Error al insertar el articulo",e);
		}
		
	}

}
 