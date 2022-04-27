package ar.com.educacionit.daos;

import ar.com.educacionit.domain.Articulo;

public interface ArticuloDao {
	public Articulo create(Articulo Articulo);
	public Articulo read(Long id);
	public Articulo update(Articulo ArticuloToUpdate);
	public Articulo delete(Long id);
	public Articulo delete(Articulo id);

}
