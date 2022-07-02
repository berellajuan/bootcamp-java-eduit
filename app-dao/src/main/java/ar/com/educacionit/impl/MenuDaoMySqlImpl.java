package ar.com.educacionit.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.daos.MenuDao;
import ar.com.educacionit.domain.Menu;

public class MenuDaoMySqlImpl  extends JDBCBaseDao<Menu> implements MenuDao{

	public MenuDaoMySqlImpl() {
		super("menu");
	}

	@Override
	public Menu formResultSetToEntity(ResultSet rs) throws SQLException {
		Long id = rs.getLong("id");
		String descripcion = rs.getString("texto");
		Long root = rs.getLong("root");
		Long idMenuPadre = rs.getLong("id_menu_padre");
		String link = rs.getString("link");
		
		return new Menu(id, descripcion, root, idMenuPadre,link);
	}

	@Override
	String getSaveSQL() {
		return " (TEXTO,ROOT,ID_MENU_PADRE,LINK) VALUES (?,?,?,?)";
	}

	@Override
	void saveData(Menu entity, PreparedStatement st) throws SQLException {
		st.setString(1, entity.getTexto());
		st.setLong(2, entity.getRoot());
		st.setLong(3, entity.getIdMenuPadre());
		st.setString(4, entity.getLink());
		
		
	}

	@Override
	String getUpdateSQL(Menu entityUpdate) {
		StringBuffer sql = new StringBuffer();

		if (entityUpdate.getTexto() != null) {
			sql.append("texto=?").append(",");
		}
		if (entityUpdate.getRoot() != null) {
			sql.append("root=?");
		}
		if (entityUpdate.getIdMenuPadre() != null) {
			sql.append("id_menu_padre=?");
		}
		if (entityUpdate.getLink() != null) {
			sql.append("link=?");
		}

		return sql.toString();
	}

	@Override
	void updateData(Menu entityUpdate, PreparedStatement st) throws SQLException {
		int idx = 1;
		if (entityUpdate.getTexto() != null) {
			st.setString(idx++, entityUpdate.getTexto());
		}
		if (entityUpdate.getRoot() != null) {
			st.setLong(idx++, entityUpdate.getRoot());
		}
		if (entityUpdate.getIdMenuPadre() != null) {
			st.setLong(idx++, entityUpdate.getIdMenuPadre());
		}
		if (entityUpdate.getLink() != null) {
			st.setString(idx++, entityUpdate.getLink());
		}
	}

}

