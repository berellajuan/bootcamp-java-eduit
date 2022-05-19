package ar.com.educacionit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.db.AdministradorDeConexiones;
import ar.com.educacionit.db.exceptions.DuplicatedException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl implements ArticuloDao {

	//private Connection con;

	public ArticuloDaoMysqlImpl() {
		/*try {
			this.con = AdministradorDeConexiones.obtenerConexion();
		} catch (GenericException e) {

			throw new IllegalArgumentException(e.getMessage(), e);
		}*/
	}

	@Override
	public void save(Articulo articulo) throws GenericException, DuplicatedException {
		
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()){
			StringBuffer  sql = new StringBuffer("INSERT INTO ARTICULOS (TITULO,CODIGO,PRECIO,STOCK,MARCAS_ID,FECHA_CREACION,CATEGORIAS_ID) VALUES (");
			sql.append("?,?,?,?,?,?,?)");

			try (PreparedStatement st = con2.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS)) {
				//execueteQuery -> consultas de tipo select
				//execuete -> son para hacer Inserts
				//executeUpdite -> Permite insert y update en al bd sirve para delete
				st.setString(1, articulo.getTitulo());
				st.setString(2, articulo.getCodigo());
				st.setDouble(3, articulo.getPrecio());
				st.setLong(7, articulo.getCategoriasId());
				st.setLong(5, articulo.getMarcasId());
				st.setDate(6, new java.sql.Date(System.currentTimeMillis()));
				st.setLong(4, articulo.getStock());
				
				st.execute();
				//para que devuelva el key, pasamos como paramenetro  PreparedStatement.RETURN_GENERATED_KEYS
				try(ResultSet rs = st.getGeneratedKeys()){
					if(rs.next()) {
						//devuelve una sika cikynba
						Long id = rs.getLong(1);
						
						articulo.setId(id);
					}
				}
				// alt+shift+m
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			if(se instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido insertar el articulo, integridad de datos violada",se);
			}
			throw new GenericException(se.getMessage(), se);
		}
	}

	@Override
	public Articulo getByPK(Long id) throws GenericException {
		// Connection
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			// Statement
			try (Statement st = con2.createStatement()) {

				// execute del sql
				// ResultSet
				System.out.println("SELECT * FROM ARTICULOS WHERE ID = " + id);
				try (ResultSet rs = st.executeQuery("SELECT * FROM ARTICULOS WHERE ID = " + id)) {
					Articulo articulo = null;
					if (rs.next()) {
						// convertir el ResultSet a Articulo
						// extraer los datos que vienen en el rs
						articulo = formResultSetToEntity(rs);
					}
					return articulo;
				}
			} catch (SQLException e) {
				throw new GenericException("No se pudo obtener el articulo id:" + id, e);
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo id:" + id, e);
		}
	}

	@Override
	public void update(Articulo articuloToUpdate) throws GenericException{
		StringBuffer sql = new StringBuffer("UPDATE ARTICULOS SET ");
		if(articuloToUpdate.getTitulo() != null) {
			sql.append("titulo=?").append(",");
		}
		if(articuloToUpdate.getCodigo() != null) {
			sql.append("codigo=?").append(",");
		}
		if(articuloToUpdate.getPrecio() != null) {
			sql.append("precio=?").append(",");
		}
		if(articuloToUpdate.getStock() != null) {
			sql.append("stock=?").append(",");
		}
		if(articuloToUpdate.getMarcasId() != null) {
			sql.append("marcas_id=?").append(",");
		}
		if(articuloToUpdate.getCategoriasId() != null) {
			sql.append("categorias_id=?").append(",");
		}
		
		sql = new StringBuffer (sql.substring(0, sql.length()-1));
		
		sql.append(" where id=?");
		
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()){

			try (PreparedStatement st = con2.prepareStatement(sql.toString())) {
				//execueteQuery -> consultas de tipo select
				//execuete -> son para hacer Inserts
				//executeUpdite -> Permite insert y update en al bd sirve para delete
				if(articuloToUpdate.getTitulo() != null) {
					st.setString(1, articuloToUpdate.getTitulo());
				}
				if(articuloToUpdate.getCodigo() != null) {
					st.setString(2, articuloToUpdate.getCodigo());
				}
				if(articuloToUpdate.getPrecio() != null) {
					st.setDouble(3, articuloToUpdate.getPrecio());
				}
				if(articuloToUpdate.getStock() != null) {
					st.setLong(4, articuloToUpdate.getStock());
				}
				if(articuloToUpdate.getMarcasId() != null) {
					st.setLong(5, articuloToUpdate.getMarcasId());
				}
				if(articuloToUpdate.getCategoriasId() != null) {
					st.setLong(6, articuloToUpdate.getCategoriasId());
				}
				
				st.setLong(7, articuloToUpdate.getId());
				st.execute();// alt+shift+m
			}
		} catch (GenericException ge) {
			throw new GenericException(ge.getMessage(), ge);
		} catch (SQLException se) {
			throw new GenericException(se.getMessage(), se);
		}
		
	}

	
	//AUTOCOMIT: ejecuta una sentencia y si sale todo bien, impacta el cambio en la bd, hasta que no se ejecute el metodo commit no se impacta en la db
	@Override
	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM ARTICULOS WHERE ID = " + id;
		Connection con2 = null;
		try {
			con2 = AdministradorDeConexiones.obtenerConexion();

			// auto commit en false
			con2.setAutoCommit(false);

			try (Statement st = con2.createStatement()) {
				//execueteQuery -> consultas de tipo select
				//execuete -> son para hacer Inserts
				//executeUpdite -> Permite insert y update en al bd sirve para delete
				st.executeUpdate(sql);// alt+shift+m
			}
			con2.commit();
		} catch (GenericException ge) {
			rollback(sql, con2);
			throw new GenericException(sql, ge);
		} catch (SQLException se) {
			rollback(sql, con2);
			throw new GenericException(sql, se);
		}

	}

	private void rollback(String sql, Connection con2) throws GenericException {
		try {
			con2.rollback();
		} catch (SQLException e) {
			throw new GenericException(sql, e);
		}
	}

	@Override
	public List<Articulo> findAll() throws GenericException {
		List<Articulo> registros = new ArrayList<>();
		// Connection
		String sql = "SELECT * FROM ARTICULOS";
		try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
			// Statement
			try (Statement st = con2.createStatement()) {
				// execute del sql
				// ResultSet
				try (ResultSet rs = st.executeQuery(sql)) {
					while(rs.next()) {
						Articulo articulo = formResultSetToEntity(rs);
						registros.add(articulo);
					}
				}
				
			} catch (SQLException e) {
				throw new GenericException("No se pudieron obtener los articulos", e);
			}
		} catch (SQLException e) {
			throw new GenericException("Error ejecutando: "+sql, e);
		}
		return registros;
	}

	private Articulo formResultSetToEntity(ResultSet rs) throws SQLException {
			// convertir el ResultSet a Articulo
			// extraer los datos que vienen en el rs
		Long idArticulo = rs.getLong("id");
		String titulo = rs.getString("titulo");
		String codigo = rs.getString("codigo");
		Date fechaCreacion = rs.getDate("fecha_creacion");
		Double precio = rs.getDouble("precio");
		Long stock = rs.getLong("stock");
		Long marcasId = rs.getLong("marcas_id");
		Long categoriasId = rs.getLong("categorias_id");
		 
		return  new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId,
				categoriasId);
	}

	@Override
	public Articulo getByCodigo(String codigo) throws GenericException {
		// Connection
				try (Connection con2 = AdministradorDeConexiones.obtenerConexion()) {
					// Statement
					String sql = "SELECT * FROM ARTICULOS WHERE codigo = ?";
					try (PreparedStatement st = con2.prepareStatement(sql)) {
						
						st.setString(1, codigo);
						try (ResultSet rs = st.executeQuery()) {
							Articulo articulo = null;
							if (rs.next()) {
								articulo = formResultSetToEntity(rs);
							}
							return articulo;
						}
					} catch (SQLException e) {
						throw new GenericException("No se pudo obtener el articulo codigo:" + codigo, e);
					}
				} catch (SQLException e) {
					throw new GenericException("No se pudo obtener el articulo codigo:" + codigo, e);
				}
		
	}


	

}
