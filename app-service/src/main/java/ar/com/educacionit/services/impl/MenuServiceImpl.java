package ar.com.educacionit.services.impl;



import ar.com.educacionit.domain.Menu;
import ar.com.educacionit.impl.MenuDaoMySqlImpl;
import ar.com.educacionit.services.MenuService;


public class MenuServiceImpl extends AbstractBaseService<Menu> implements MenuService {

	public MenuServiceImpl() {
		super(new MenuDaoMySqlImpl());
	}



}
