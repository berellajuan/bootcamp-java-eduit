package ar.com.educacionit.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.SociosDao;
import ar.com.educacionit.domain.Socios;



public class SociosDaoMysqlImpl extends JDBCBaseDao<Socios> implements SociosDao{

	public SociosDaoMysqlImpl() {
		super("socios");
	}

	@Override
	String getSaveSQL() {
		return "(APELLIDO,NOMBRE,CODIGO) VALUES (?,?,?)";
	}

	@Override
	void saveData(Socios entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getApellido());
		st.setString(2, entity.getNombre());
		st.setString(3, entity.getCodigo());
	}

	@Override
	String getUpdateSQL(Socios entityUpdate) {
		StringBuffer sql = new StringBuffer();
		
		if (entityUpdate.getApellido() != null) {
			sql.append("apellido=?").append(",");
		}
		if (entityUpdate.getNombre() != null) {
			sql.append("nombre=?").append(",");
		}
		if (entityUpdate.getCodigo() != null) {
			sql.append("codigo=?").append(",");
		}

		return sql.toString();
	}

	@Override
	void updateData(Socios entityUpdate, PreparedStatement st) throws SQLException {
		int idx=1;
		if (entityUpdate.getNombre() != null) {
			st.setString(idx++, entityUpdate.getNombre());
		}
		if (entityUpdate.getApellido() != null) {
			st.setString(idx++, entityUpdate.getApellido());
		}
		if (entityUpdate.getCodigo() != null) {
			st.setString(idx++, entityUpdate.getCodigo());
		}
	}

	@Override
	public Socios formResultSetToEntity(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String apellido = rs.getString("apellido");
		String nombre = rs.getString("nombre");
		String codigo = rs.getString("codigo");
		
		return new Socios(id,apellido, nombre, codigo);
	}



}
