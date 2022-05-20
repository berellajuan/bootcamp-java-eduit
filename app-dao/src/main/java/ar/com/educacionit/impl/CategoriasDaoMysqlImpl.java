package ar.com.educacionit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import ar.com.educacionit.daos.CategoriasDao;
import ar.com.educacionit.db.AdministradorDeConexiones;
import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;


public class CategoriasDaoMysqlImpl extends JDBCBaseDao<Categorias> implements CategoriasDao {

	//private Connection con;

	public CategoriasDaoMysqlImpl() {
		super("categorias");
	}

	@Override
	public void save(Categorias Categorias) throws GenericException, DuplicatedException {
		
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()){
			StringBuffer  sql = new StringBuffer("INSERT INTO CategoriasS (TITULO,CODIGO,PRECIO,STOCK,MARCAS_ID,FECHA_CREACION,CATEGORIAS_ID) VALUES (");
			sql.append("?,?,?,?,?,?,?)");

			try (PreparedStatement st = con2.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS)) {
				//execueteQuery -> consultas de tipo select
				//execuete -> son para hacer Inserts
				//executeUpdite -> Permite insert y update en al bd sirve para delete
			
				//para que devuelva el key, pasamos como paramenetro  PreparedStatement.RETURN_GENERATED_KEYS
				try(ResultSet rs = st.getGeneratedKeys()){
					if(rs.next()) {
						//devuelve una sika cikynba
						Long id = rs.getLong(1);
						
						Categorias.setId(id);
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


	@Override
	public void update(Categorias CategoriasToUpdate) throws GenericException{
		
	}

	


	public Categorias formResultSetToEntity(ResultSet rs) throws SQLException {
			// convertir el ResultSet a Categorias
			// extraer los datos que vienen en el rs
		Long idCategorias = rs.getLong("id");
		String descripcion = rs.getString("descripcion");
		Long habilitada = rs.getLong("habilitada");

		 
		return  new Categorias(idCategorias,descripcion,habilitada);
	}

	
		
}



