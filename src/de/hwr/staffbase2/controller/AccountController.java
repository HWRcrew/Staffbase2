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
import de.hwr.staffbase2.model.EmployeeDAO;
import de.hwr.staffbase2.model.EmployeeDAOFactory;
import de.hwr.staffbase2.model.EmployeeFactory;

/**
 * Servlet implementation class AdminController
 */

@WebServlet("/AccountController")
public class AccountController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String idString = request.getParameter("id");
		String pw1 = request.getParameter("new_password");
		String pw2 = request.getParameter("new_password_resume");
		boolean manager;
		if(request.getParameter("checkbox_manager") == null){
			manager = false;
		}else{
			manager = true;
		}
		long id = Long.parseLong(idString);
		RequestDispatcher dispatcher = null;
		
		if(checkValues(username, pw1, pw2)){
			
			if(pw1.equals(pw2)){
				
				AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
				Account account = AccountFactory.getInstance().getAccount();
				account.setManager(manager);
				account.setPassword(pw1);
				account.setUsername(username);
				
				
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
				Employee employee = employeeDAO.find(id);//EmployeeFactory.getInstance().getEmployee();
				
				account.setEmployee(employee);
				employee.setAccount(account);
				
				accountDAO.insert(account);
				employeeDAO.update(employee);
				
				dispatcher = getServletContext().getRequestDispatcher("/settings_details.jsp?change="+id);
				
			}else{
				request.setAttribute("errorMessage", "Inkorrekte Eingabe: Die beiden Passwörter stimmen nicht überein.");
				dispatcher = getServletContext().getRequestDispatcher("/settings_account.jsp?accID="+id);
				dispatcher.forward(request, response);
				return;
			}
			
		}else{
			request.setAttribute("errorMessage", "Inkorrekte Eingabe: Alle Pflichtfelder müssen eingetragen sein.");
			dispatcher = getServletContext().getRequestDispatcher("/settings_account.jsp?accID="+id);
		}
		
		dispatcher.forward(request, response);
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
	
	private boolean checkValues(String value1, String value2, String value3){
		boolean check = false;
		value1 = value1.replaceAll(" ", "");
		value2 = value2.replaceAll(" ", "");
		value3 = value3.replaceAll(" ", "");
		if(!value1.equals("") && !value2.equals("") && !value3.equals("")){
			check = true;
		}
		return check;
	}

}
