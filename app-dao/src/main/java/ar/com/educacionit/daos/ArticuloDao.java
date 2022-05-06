package ar.com.educacionit.daos;

import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public interface ArticuloDao {
	public Articulo save(Articulo Articulo);
	public Articulo getByPK(Long pk) throws GenericException;
	public Articulo update(Articulo ArticuloToUpdate);
	public void delete(Long id) throws GenericException;

}
