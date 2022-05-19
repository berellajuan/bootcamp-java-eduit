package ar.com.educacionit.daos;


import java.util.List;

import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

/**
 * 
 * @author LopezCar
 *
 */
public interface ArticuloDao {

	//definir los metodos CRUD
	public List<Articulo> findAll() throws GenericException;
	public void save(Articulo orden) throws GenericException, DuplicatedException;
	public Articulo getByPK(Long pk) throws GenericException;
	public void update(Articulo ordenToUpdate) throws GenericException;
	public void delete(Long pk) throws GenericException;
	public Articulo getByCodigo(String codigo)throws GenericException;
 }
