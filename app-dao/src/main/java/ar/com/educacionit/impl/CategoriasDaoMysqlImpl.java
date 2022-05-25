package ar.com.educacionit.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import ar.com.educacionit.daos.CategoriasDao;

import ar.com.educacionit.domain.Categorias;

public class CategoriasDaoMysqlImpl extends JDBCBaseDao<Categorias> implements CategoriasDao {

	// private Connection con;

	public CategoriasDaoMysqlImpl() {
		super("categorias");
	}

	@Override
	public String getSaveSQL() {
		return " (DESCRIPCION,HABILITADA) VALUES (?,?)";
	}

	@Override
	public void saveData(Categorias entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getDescripcion());
		st.setInt(2, entity.getHabilitada());
	}

	@Override
	public String getUpdateSQL(Categorias entityUpdate) {
		StringBuffer sql = new StringBuffer();

		if (entityUpdate.getDescripcion() != null) {
			sql.append("descripcion=?").append(",");
		}
		if (entityUpdate.getHabilitada() != null) {
			sql.append("habilitada=?");
		}

		return sql.toString();
	}

	@Override
	public void updateData(Categorias entityUpdate, PreparedStatement st) throws SQLException {
		int idx = 1;
		if (entityUpdate.getDescripcion() != null) {
			st.setString(idx++, entityUpdate.getDescripcion());
		}
		if (entityUpdate.getHabilitada() != null) {
			st.setInt(idx++, entityUpdate.getHabilitada());
		}

	}

	@Override
	public Categorias formResultSetToEntity(ResultSet rs) throws SQLException {
		Long idCategorias = rs.getLong("id");
		String descripcion = rs.getString("descripcion");
		Integer habilitada = rs.getInt("habilitada");
		return new Categorias(idCategorias, descripcion, habilitada);
	}

}
