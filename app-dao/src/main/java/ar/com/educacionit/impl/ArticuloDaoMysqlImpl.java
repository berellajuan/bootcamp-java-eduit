package ar.com.educacionit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.db.AdministradorDeConexiones;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl extends JDBCBaseDao<Articulo> implements ArticuloDao {

	// private Connection con;

	public ArticuloDaoMysqlImpl() {
		super("articulos");
	}

	// Este metodo Realiza el cuerpo la Query Especifica
	@Override
	public String getSaveSQL() {

		return " (TITULO, CODIGO, PRECIO, CATEGORIAS_ID, MARCAS_ID, FECHA_CREACION, STOCK) VALUES (?,?,?,?,?,?,?)";
	}

	// Este Metodo completa la Query especifica el PreparedStatement setea los datos
	@Override
	public void saveData(Articulo entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getTitulo());
		st.setString(2, entity.getCodigo());
		st.setDouble(3, entity.getPrecio());
		st.setLong(4, entity.getCategoriasId());
		st.setLong(5, entity.getMarcasId());
		st.setDate(6, new java.sql.Date(System.currentTimeMillis()));
		st.setLong(7, entity.getStock());
	}


	// setea los datos y devuelve un articulo
	public Articulo formResultSetToEntity(ResultSet rs) throws SQLException {
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

		return new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
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

	@Override
	public String getUpdateSQL(Articulo entityUpdate) {
		StringBuffer sql = new StringBuffer();
		
		if (entityUpdate.getTitulo() != null) {
			sql.append("titulo=?").append(",");
		}
		if (entityUpdate.getPrecio() != null) {
			sql.append("precio=?").append(",");
		}
		if (entityUpdate.getStock() != null) {
			sql.append("stock=?").append(",");
		}
		if (entityUpdate.getMarcasId() != null) {
			sql.append("marcas_id=?").append(",");
		}
		if (entityUpdate.getCategoriasId() != null) {
			sql.append("categorias_id=?");
		}
		
		return sql.toString();
	}

	@Override
	public void updateData(Articulo entityUpdate, PreparedStatement st) throws SQLException {
		int idx=1;
		if (entityUpdate.getTitulo() != null) {
			st.setString(idx++, entityUpdate.getTitulo());
		}
		if (entityUpdate.getPrecio() != null) {
			st.setDouble(idx++, entityUpdate.getPrecio());
		}
		if (entityUpdate.getStock() != null) {
			st.setLong(idx++, entityUpdate.getStock());
		}
		if (entityUpdate.getMarcasId() != null) {
			st.setLong(idx++, entityUpdate.getMarcasId());
		}
		if (entityUpdate.getCategoriasId() != null) {
			st.setLong(idx++, entityUpdate.getCategoriasId());
		}
		
	}

}
