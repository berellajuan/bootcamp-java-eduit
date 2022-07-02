package ar.com.educacionit.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.AttributeEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = -2426387967785338153L;

	public void redirect(ViewsEnum view, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view.getValue() da el valor que contiene el enum
		getServletContext().getRequestDispatcher(view.getValue()).forward(request, response);
	}
	
	public void setAttribute(AttributeEnum attribute, HttpServletRequest req,Object value) {
		req.setAttribute(attribute.getValue(), value);
	}
}
