package ar.com.educacionit.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import ar.com.educacionit.daos.ArticuloDao;
import ar.com.educacionit.db.AdministradorDeConexiones;
import ar.com.educacionit.db.ConexionDB;
import ar.com.educacionit.db.exceptions.ConnectionException;
import ar.com.educacionit.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

public class ArticuloDaoMysqlImpl implements ArticuloDao {
	
	private Connection con;
	
	public ArticuloDaoMysqlImpl() {
		try {
			this.con = AdministradorDeConexiones.obtenerConexion();
		} catch (GenericException e) {
			
			throw new IllegalArgumentException(e.getMessage(),e);
		}
	}

	@Override
	public Articulo save(Articulo Articulo) {
		
		return Articulo;
	}

	@Override
	public Articulo getByPK(Long id) throws GenericException {
		//Connection
		//Statement
		try(Statement st =this.con.createStatement()) {
		
			//execute del sql / consulta
			try(ResultSet rs = st.executeQuery("SELECT * FROM ARTICULOS WHERE ID = "+id)){
				Articulo art = null;
				if(rs.next()) {
					//extraer datos que vienen de la consulta
					Long idArticulo = rs.getLong("id");
					String titulo = rs.getString("titulo");
					String codigo = rs.getString("codigo");
					Date fechaCreacion = rs.getDate("fecha_creacion");
					Double precio = rs.getDouble("precio");
					Long stock = rs.getLong("stock");
					Long marcasId = rs.getLong("marcas_id");
					Long categoriasId = rs.getLong("categorias_id");
					
					art = new Articulo(idArticulo, titulo, codigo, fechaCreacion, precio, stock, marcasId, categoriasId);
					
				}
				return art;
			} 
		}catch (SQLException e) {
			throw new GenericException("No se pudo obtener el articulo id:"+id,e);
		}
	}

	@Override
	public Articulo update(Articulo ArticuloToUpdate) {
	
		return null;
	}

	@Override
	public void delete(Long id) throws GenericException {
		String sql = "DELETE FROM TABLA HERE ID = "+ id;
		
		try(Connection con2 = AdministradorDeConexiones.obtenerConexion()){
			con2.setAutoCommit(false);
			try(Statement st = con2.createStatement()){
				st.executeUpdate(sql);
			}
			//con2.commit();
		}catch (GenericException ge) {
			//con2.rollback();
			throw new GenericException(sql, ge);
		} catch (SQLException e) {
			throw new GenericException(sql, e);
		}
		
	}


}
