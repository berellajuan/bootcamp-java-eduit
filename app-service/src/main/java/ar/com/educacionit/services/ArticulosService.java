package ar.com.educacionit.services;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticulosService {
	public Articulo getById(Long id) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;

}
