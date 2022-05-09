package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticuloServiceImpl implements ArticulosService {
	
	private ArticuloDao dao;
	
	public ArticuloServiceImpl(){
		this.dao = new ArticuloDaoMysqlImpl();
	}
	
	@Override
	public Articulo getById(Long id) throws ServiceException {
		try {
			return dao.getByPK(id);
		} catch (GenericException e) {
			throw new ServiceException("Error al consultar articulo",e);
		}
	}

	@Override
	public void deleteArticulo(Long id) throws ServiceException {
		try {
			dao.delete(id);
		} catch (GenericException e) {
			throw new ServiceException("Error al borrar el articulo",e);
		}
		
	}

	@Override
	public void updateArticulo(Articulo entity) throws ServiceException {
		try {
			dao.update(entity);
		} catch (GenericException e) {
			throw new ServiceException("Error al actualizar el articulo",e);
		}		
	}

	@Override
	public List<Articulo> obtenerTodos() throws ServiceException {
		try {
			return dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("Error al consultar los articulo",e);
		}	
	}

}
 