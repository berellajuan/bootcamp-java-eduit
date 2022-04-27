package ar.com.educacionit.daos;

import ar.com.educacionit.domain.Orden;

public interface OrdenDao {
	public Orden create(Orden orden);
	public Orden read(Long id);
	public Orden update(Orden ordenToUpdate);
	public Orden delete(Long id);
	public Orden delete(Orden id);

}
