package ar.com.educacionit.web.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;
import ar.com.educacionit.web.enums.AttributeEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

@WebServlet("/controller/form")
public class AltaFormularioServlet extends BaseServlet {

	private static final long serialVersionUID = 5626936385952858404L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// capturar los datos que se enviaron del form
		String fecha = request.getParameter("fecha"); // String

		// aplica logica

		// responder
		// response.getWriter().print("se ha grabado su orden");
		
		//Double id  = Math.random();
		
		//pasar a la siguiente pagina
		//guardo en el request el dato bajo un clave
		//request.setAttribute("idGen", id);
		
		ArticuloServiceImpl ar = new ArticuloServiceImpl();
		try {
			Collection<Articulo> list = ar.findAll();
			//request.setAttribute(AttributeEnum.ARTICULOS.getValue(), list);
			setAttribute(AttributeEnum.ARTICULOS, request, list);
			// redireccion a otra pagina
			// con esta linea puedo ir a otra pagina, y forward le pasa el request y
			// response
			
			redirect(ViewsEnum.REGISTRO_OK, request, response);
		} catch (ServiceException e) {
			redirect(ViewsEnum.REGISTRO_FAIL, request, response);
		}


	}
}
