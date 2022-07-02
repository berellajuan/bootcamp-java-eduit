package ar.com.educacionit.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ar.com.educacionit.domain.Menu;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.MenuServiceImpl;

@WebServlet("/controllers/menu")
public class MenuController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MenuServiceImpl ms = new MenuServiceImpl();
		
		try {
			Collection<Menu> list = ms.findAll();
			
			for(Menu men: list) {
				ArrayList<Menu> subMenus = new ArrayList<>();
				if(men.getIdMenuPadre() == 0) {
					for(Menu men2: list) {
						if(men2.getIdMenuPadre()!=0 && men2.getIdMenuPadre() == men.getId()) {
								subMenus.add(men2);
						}
					}
					men.setSubMenu(subMenus);
				}
			}
			
			req.setAttribute("menu", list);
			// OK
			getServletContext().getRequestDispatcher("/menu.jsp").forward(req, resp);
		} catch (ServiceException e) {
			// FAIL
			getServletContext().getRequestDispatcher("/registroFail.jsp").forward(req, resp);
		}

	}

}
