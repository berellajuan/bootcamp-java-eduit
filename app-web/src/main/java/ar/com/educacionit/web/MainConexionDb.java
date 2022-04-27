package ar.com.educacionit.web;

import ar.com.educacionit.daos.OrdenDao;
import ar.com.educacionit.domain.Orden;
import ar.com.educacionit.impl.OrdenDaoImpl;

public class MainConexionDb {

	public static void main(String[] args) {
		OrdenDao dao = new OrdenDaoImpl();
		Orden o = new Orden(1l,"Test",150f);
		dao.create(o);
	}

}
