package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.services.GenericService;
import ar.com.educacionit.services.exceptions.ServiceException;

public abstract class AbstractBaseService<T> implements GenericService<T> {
	
	protected GenericDao<T> dao;
	
	public AbstractBaseService(GenericDao<T> dao) {
		this.dao =dao;
	}

	@Override
	public T getById(Long id) throws ServiceException {
		try {
			return dao.getByPK(id);
		} catch (GenericException e) {
			throw new ServiceException("Error al consultar T",e);
		}
	}

	@Override
	public void delete(Long id) throws ServiceException {
		try {
			dao.delete(id);
		} catch (GenericException e) {
			throw new ServiceException("Error al borrar el T",e);
		}
		
	}

	@Override
	public void update(T entity) throws ServiceException {
		try {
			dao.update(entity);
		} catch (GenericException e) {
			throw new ServiceException("Error al actualizar el T",e);
		}		
	}

	@Override
	public List<T> findAll() throws ServiceException {
		try {
			return dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("Error al consultar los T",e);
		}	
	}

	@Override
	public void create(T nuevo) throws ServiceException {
		try {
			dao.save(nuevo);
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException("Error al insertar el T",e);
		}	
		
	}

}
