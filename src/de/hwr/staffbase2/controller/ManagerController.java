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
 * Servlet implementation class ManagerController
 */
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		final String login = request.getParameter("login");
		final String insert = request.getParameter("insert");
		RequestDispatcher dispatcher = null;
		
		if("1".equalsIgnoreCase(login)){
			dispatcher = getServletContext().getRequestDispatcher("/settings_manager.jsp");
			dispatcher.forward(request, response);
		}else if("1".equalsIgnoreCase(insert)){
			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String pw1 = request.getParameter("new_password");
			String pw2 = request.getParameter("new_password_resume");
			boolean manager;
			if(request.getParameter("checkbox_manager") == null){
				manager = false;
			}else{
				manager = true;
			}
			
			if(checkValues(name, username, pw1, pw2)){
			
				if(pw1.equals(pw2)){

					AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
					Account account = AccountFactory.getInstance().getAccount();
					account.setManager(manager);
					account.setPassword(pw1);
					account.setUsername(username);
				
				
					EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
					Employee employee = EmployeeFactory.getInstance().getEmployee();
					employee.setSurname(name);
					employee.setAccount(account);

					account.setEmployee(employee);
				
					accountDAO.insert(account);
					employeeDAO.insert(employee);

					long id = employee.getId();
					dispatcher = getServletContext().getRequestDispatcher("/EmployeeController?change="+id);
				}else{
					request.setAttribute("errorMessage", "Inkorrekte Eingabe: Die eingegebenen Passw�rter stimmen nicht �berein.");
					dispatcher = getServletContext().getRequestDispatcher("/settings_manager.jsp");
				}
			}else{
				request.setAttribute("errorMessage", "Inkorrekte Eingabe: Alle Pflichtfelder m�ssen eingetragen sein.");
				request.setAttribute("name", name);
				request.setAttribute("username", username);
				request.setAttribute("new_password", "");
				request.setAttribute("new_password_resume", "");
				dispatcher = getServletContext().getRequestDispatcher("/settings_manager.jsp");
			
			}
			dispatcher.forward(request, response);
		}else{
			dispatcher = getServletContext().getRequestDispatcher("/");
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
	
	private boolean checkValues(String value1, String value2, String value3, String value4){
		boolean check = false;
		value1 = value1.replaceAll(" ", "");
		value2 = value2.replaceAll(" ", "");
		value3 = value3.replaceAll(" ", "");
		value4 = value4.replaceAll(" ", "");
		if(!value1.equals("") && !value2.equals("") && !value3.equals("") && !value4.equals("")){
			check = true;
		}
		return check;
	}

}
