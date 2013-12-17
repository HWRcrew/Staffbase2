package de.hwr.staffbase2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hwr.staffbase2.model.Account;
import de.hwr.staffbase2.model.AccountDAO;
import de.hwr.staffbase2.model.AccountDAOFactory;
import de.hwr.staffbase2.model.AccountFactory;
import de.hwr.staffbase2.model.Employee;

@WebServlet("/NavigationController")
public class NavigationController extends HttpServlet{

	/**
	 * NavigationController
	 */
	private static final long serialVersionUID = 1L;
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("ja hier bin ich !!!");
		
		boolean sessionmanager;
		RequestDispatcher dispatcher = null;
		String userString;
		
		if(request.getSession(false) == null){
			System.out.println("Sie werden ausgeloggt!");
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("password");
			request.getSession().removeAttribute("manager");
			request.getSession().removeAttribute("admin");
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			request.setAttribute("errorMessage", "Session timed out. Please sign- in again!");
			dispatcher.forward(request, response);
			return;
		}
		
		userString = (String) request.getSession().getAttribute("username");
		sessionmanager = (Boolean) request.getSession().getAttribute("manager");
		
		if (request.getParameter("sign-out") != null){
			request.getSession().removeAttribute("username");
			request.getSession().removeAttribute("password");
			request.getSession().removeAttribute("manager");
			request.getSession().removeAttribute("admin");

			System.out.println("Sie werden ausgeloggt!");
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		 }else if (request.getParameter("profile_settings") != null){
			 dispatcher = getServletContext().getRequestDispatcher("/settings.jsp");
				dispatcher.forward(request, response);
		 }else if(request.getParameter("profile_edit") != null){
			 long mID =0;
			 Employee emp = null;

				AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
				Account account = AccountFactory.getInstance().getAccount();
				account = accountDAO.find(userString);
				if(account != null){
					emp = account.getEmployee();
				}
				if(emp != null){
					mID = emp.getId();
				}
			 dispatcher = getServletContext().getRequestDispatcher("/settings_details_editable.jsp?change="+mID+"&edit=1");
				dispatcher.forward(request, response);
		 }else if(request.getParameter("profile_my") != null){
			 long mID =0;
			 Employee emp = null;

				AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
				Account account = AccountFactory.getInstance().getAccount();
				account = accountDAO.find(userString);
				if(account != null){
					emp = account.getEmployee();
				}
				if(emp != null){
					mID = emp.getId();
				}
			 dispatcher = getServletContext().getRequestDispatcher("/settings_details.jsp?change="+mID+"&edit=1");
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
