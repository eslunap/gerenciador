package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		DB baseDeDatos = new DB();
		List<Empresa> listaEmpresas = baseDeDatos.getEmpresas();
		
		request.setAttribute("listaEmpresas", listaEmpresas);
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
				
		/*
		 * PrintWriter out = response.getWriter(); out.println("<html>" + "<body>" +
		 * "<ul>"); for (Empresa empresa : listaEmpresas) { out.println("<li>" +
		 * empresa.getNombre() + "</li>"); } out.println("</ul>" + "</body>" +
		 * "</html>");
		 */

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
