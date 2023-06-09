package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NuevaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("nueva empresa registrada");
		
		String nombreEmpresa = request.getParameter("nombre");
		String paramFechaApertura = request.getParameter("fecha");
		
		Date fechaApertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			fechaApertura = sdf.parse(paramFechaApertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNombre(nombreEmpresa);
		empresa.setFechaApertura(fechaApertura);
		
		DB baseDeDatos = new DB(); 
		baseDeDatos.agregarEmpresa(empresa);
		
		request.setAttribute("nombreEmpresa", empresa.getNombre());

		//redireccionamiento al navegador
		response.sendRedirect("listaEmpresas");
		
		//Llamar al jsp
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		 * request.setAttribute("nombreEmpresa", empresa.getNombre());
		 * rd.forward(request, response);
		 */
		
		/*
		 * PrintWriter out = response.getWriter(); out.println("<html>" + "<body>" +
		 * "Empresa " + nombreEmpresa + " registrada!" + "</body>" + "</html>");
		 */
	}
}