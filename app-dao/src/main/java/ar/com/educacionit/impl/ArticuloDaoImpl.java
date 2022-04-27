package ar.com.educacionit.impl;

import ar.com.educacionit.daos.ArticuloDao;

import ar.com.educacionit.db.ConexionDB;
import ar.com.educacionit.db.exceptions.ConnectionException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoImpl implements ArticuloDao {
	
	private ConexionDB con;
	
	public ArticuloDaoImpl() {
		this.con = new ConexionDB("root", "1234");
	}

	@Override
	public Articulo create(Articulo Articulo) {
		
		try(ConexionDB con = this.con.open()){
			Articulo.setId(1L);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		return Articulo;
	}

	@Override
	public Articulo read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo update(Articulo ArticuloToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo delete(Articulo id) {
		// TODO Auto-generated method stub
		return null;
	}

}
