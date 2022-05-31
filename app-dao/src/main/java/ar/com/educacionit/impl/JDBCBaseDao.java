package ar.com.educacionit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.daos.GenericDao;
import ar.com.educacionit.db.AdministradorDeConexiones;
import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Entity;

public abstract class JDBCBaseDao<T extends Entity> implements GenericDao<T> {
	protected String tabla;

	public JDBCBaseDao(String tabla) {
		if (tabla == null) {
			throw new IllegalArgumentException("Debe incluir la tabla del DAO");
		}
		this.tabla = tabla;
	}
	
	
	public  String getSaveSQL() {
		return "vacio";
	};
	
	public  void saveData(T entity, PreparedStatement pstm) throws SQLException{
		
	};
	
	public void save(T entity) throws GenericException, DuplicatedException {
		
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()){
			
			
			StringBuffer  sql = new StringBuffer("INSERT INTO ").append(this.tabla).append(this.getSaveSQL());
			
			try (PreparedStatement st = con2.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				//necesito una entity y un statement para generar la consulta
				this.saveData(entity, st);
				
				st.execute();
				
				try(ResultSet rs = st.getGeneratedKeys()){
					if(rs.next()) {
						//devuelve una key
						Long id = rs.getLong(1);
						
						entity.setId(id);
					}
				}
				// alt+shift+m
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			if(se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el Categorias, integridad de datos violada",se);
			}
			throw new GenericException(se.getMessage(), se);
		}
	}

	public  String getUpdateSQL(T entityUpdate) {
		return "vacio";
	};
	
	public void updateData(T entityUpdate, PreparedStatement st) throws SQLException{
		
	};
	
	@Override
	public void update(T entityUpdate) throws GenericException {
		
		StringBuffer sql = new StringBuffer("UPDATE ").append(this.tabla).append(" SET ") .append(this.getUpdateSQL(entityUpdate))
				.append(" where id=?");
		
		//Forma para buscar el ultimo ?
		int idx = getWhereIndex(sql);
	
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {

			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {
				
				this.updateData(entityUpdate,st);
				
				st.setLong(idx, entityUpdate.getId());

				st.execute();
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}

	}

	//Determina el indice del where
	private int getWhereIndex(StringBuffer sql) {
		int idx = 0;
		for(char c : sql.toString().toCharArray()) {
			if(c == '?') {
				idx ++;
			}
		}
		return idx;
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
	
	@Override
	public List<T> findPageable(Integer currentPage,Integer size) throws GenericException {
		List<T> registros = new ArrayList<>();
		String sql = "SELECT * FROM " + this.tabla +" LIMIT "+ size + " OFFSET " + (currentPage-1);
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


	// Cada hijo decide que tabla utiliza
	public abstract T formResultSetToEntity(ResultSet rs) throws SQLException;
}
