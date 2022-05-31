package ar.com.educacionit.services.files;

import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.domain.Menu;

public class MenuRecursivo {
	public static void main(String[] args) {
		/*List<Menu> menus = getMenuFromDB();
		mostrarMenu(menus);*/

	}

	private static void mostrarMenu(List<Menu> menus) {

		for (Menu m : menus) {
			System.out.println(m.getTexto());
			if (m.isRoot()) {
				System.out.println("-----------");
			}

			mostrarMenu(m.getSubMenu());

		}
	}
/*
	private static List<Menu> getMenuFromDB() {
		List<Menu> subMenu = new ArrayList<>();
		Menu html = new Menu("HTML", new ArrayList<>(), false);
		subMenu.add(html);

		Menu referencias = new Menu("H1", subMenu, true);

		Menu hijosGuide = new Menu("References", new ArrayList<>(), false);
		List<Menu> submenuHG = new ArrayList<>();
		submenuHG.add(hijosGuide);

		subMenu = new ArrayList<>();
		Menu mdn = new Menu("MDN", submenuHG, false);
		subMenu.add(mdn);

		Menu guides = new Menu("Guides", subMenu, true);

		List<Menu> menus = new ArrayList<>();
		menus.add(referencias);
		menus.add(guides);

		return menus;
	}*/
}
