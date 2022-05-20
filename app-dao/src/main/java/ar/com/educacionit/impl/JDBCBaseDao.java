package ar.com.educacionit.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.db.AdministradorDeConexiones;
import ar.com.educacionit.db.exceptions.GenericException;

public abstract class JDBCBaseDao<T> implements GenericDao<T> {
	protected String tabla;

	public JDBCBaseDao(String tabla) {
		if (tabla == null) {
			throw new IllegalArgumentException("Debe incluir la tabla del DAO");
		}
		this.tabla = tabla;
	}

	@Override
	public T getByPK(Long id) throws GenericException {
		// Connection
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			// Statement
			try (Statement st = con2.createStatement()) {

				// execute del sql
				// ResultSet
				String sql = "SELECT * FROM" + this.tabla + "WHERE ID = " + id;

				try (ResultSet rs = st.executeQuery(sql)) {
					T entity = null;
					if (rs.next()) {
						// convertir el ResultSet a Categorias
						// extraer los datos que vienen en el rs
						entity = this.formResultSetToEntity(rs);
					}
					return entity;
				}
			} catch (SQLException e) {
				throw new GenericException("No se pudo obtener el entity id:" + id, e);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el entity" + this.tabla + "id:" + id, e);
		}
	}

	@Override
	public List<T> findAll() throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla;
		// Connection
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement();
				ResultSet rs = st.executeQuery(sql)) {

			while (rs.next()) {
				T entity = this.formResultSetToEntity(rs);
				registros.add(entity);
			}

		} catch (SQLException e) {
			throw new GenericException("Error ejecutando: " + sql, e);
		}
		return registros;
	}
	
	// AUTOCOMIT: ejecuta una sentencia y si sale todo bien, impacta el cambio en la
	// bd, hasta que no se ejecute el metodo commit no se impacta en la db
	@Override
	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM "+ this.tabla +" WHERE ID = " + id;
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion();
				Statement st = con2.createStatement()){
				st.executeUpdate(sql);// alt+shift+m
		} catch (GenericException ge) {
			throw new GenericException(sql, ge);
		} catch (SQLException se) {
			throw new GenericException(sql, se);
		}

	}


	// Cada hijo decide que tabla utiliza
	public abstract T formResultSetToEntity(ResultSet rs) throws SQLException;
}
