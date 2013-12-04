package de.hwr.staffbase2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hwr.staffbase2.model.Employee;
import de.hwr.staffbase2.model.EmployeeDAO;
import de.hwr.staffbase2.model.EmployeeDAOFactory;
import de.hwr.staffbase2.model.EmployeeFactory;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		RequestDispatcher dispatcher = null;
		String change = request.getParameter("change");
		String update = request.getParameter("update");
		
		if(change != null){
			dispatcher = getServletContext().getRequestDispatcher("/settings_details_editable.jsp");
			
		}else if("1".equalsIgnoreCase(update)){
			
			String name = request.getParameter("name");
			System.out.println(name);
			Long id = Long.parseLong(request.getParameter("_id"));
			String prename = request.getParameter("prename");
			String street = request.getParameter("street");
			int zipcode = Integer.parseInt(request.getParameter("zipcode"));
			String city = request.getParameter("city");
			
			Employee employee = EmployeeFactory.getInstance().getEmployee();
			employee.setId(id);
			employee.setSurname(name);
			employee.setPrename(prename);
			employee.setStreet(street);
			employee.setZipcode(zipcode);
			employee.setCity(city);

			EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
			employeeDAO.update(employee);
			
			dispatcher = getServletContext().getRequestDispatcher("/settings_details_editable.jsp");
			
		}else{
			
			dispatcher = getServletContext().getRequestDispatcher("/tables_employee.jsp");
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

}
