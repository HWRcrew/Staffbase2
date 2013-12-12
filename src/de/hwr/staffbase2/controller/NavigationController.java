package de.hwr.staffbase2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NavigationController")
public class NavigationController extends HttpServlet{

	/**
	 * NavigationController
	 */
	private static final long serialVersionUID = 1L;
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("ja hier bin ich !!!");
		
		boolean sessionmanager;
		RequestDispatcher dispatcher = null;
		
		if(request.getSession(false) == null){
			System.out.println("Sie werden ausgeloggt!");
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			request.setAttribute("errorMessage", "Session timed out. Please sign- in again!");
			dispatcher.forward(request, response);
			return;
		}
		
		sessionmanager = (Boolean) request.getSession().getAttribute("manager");
		
		if (request.getParameter("sign-out") != null){
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("password");
			request.getSession().removeAttribute("manager");

			System.out.println("Sie werden ausgeloggt!");
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		 }else if (request.getParameter("account") != null){
			 dispatcher = getServletContext().getRequestDispatcher("/settings.jsp");
				dispatcher.forward(request, response);
		 }else if (request.getParameter("employee") != null){
			 dispatcher = getServletContext().getRequestDispatcher("/tables_employee.jsp");
				dispatcher.forward(request, response);
		 }else if (request.getParameter("department") != null){
			 dispatcher = getServletContext().getRequestDispatcher("/tables_department.jsp");
				dispatcher.forward(request, response);
		 }else if (request.getParameter("place") != null){
			 dispatcher = getServletContext().getRequestDispatcher("/tables_position.jsp");
				dispatcher.forward(request, response);
		 }
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request, response);
	}

}
