package ar.com.educacionit.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ActionBuilder;
import ar.com.educacionit.web.enums.FormatoEnum;
import ar.com.educacionit.web.enums.IFormato;

@WebServlet("/controllers/exportar")
public class ExportarController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String formato = req.getParameter("formato");
		
		//pido el enum si .valueOf no existe lo que le mando larga una execpcio
		 FormatoEnum _enum = FormatoEnum.valueOf(formato);
		 //pido action que devuelva el formato
		 IFormato action = ActionBuilder.getAction(_enum);
		 //ejecuto
		 action.doAction();
	}
}
