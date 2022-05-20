package ar.com.educacionit.daos;


import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

/**
 * 
 * @author LopezCar
 *
 */
public interface ArticuloDao extends GenericDao<Articulo>{
	public Articulo getByCodigo(String codigo)throws GenericException;
 }
