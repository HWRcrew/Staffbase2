package de.hwr.staffbase2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hwr.staffbase2.model.Department;
import de.hwr.staffbase2.model.DepartmentDAO;
import de.hwr.staffbase2.model.DepartmentDAOFactory;
import de.hwr.staffbase2.model.Employee;
import de.hwr.staffbase2.model.EmployeeDAO;
import de.hwr.staffbase2.model.EmployeeDAOFactory;
import de.hwr.staffbase2.model.EmployeeFactory;
import de.hwr.staffbase2.model.Job;
import de.hwr.staffbase2.model.JobDAO;
import de.hwr.staffbase2.model.JobDAOFactory;

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
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = null;
		String change = request.getParameter("change");
		String insert = request.getParameter("insert");
		String update = request.getParameter("update");

		if(change != null){
			dispatcher = getServletContext().getRequestDispatcher("/settings_details_editable.jsp");
			
		}else if("1".equalsIgnoreCase(update)){
				
				String name = request.getParameter("name");
				String idstring = request.getParameter("id");
				long id = 0;
				if(idstring != null){
					id = Long.parseLong(idstring);
				}
				String prename = request.getParameter("prename");
				String street = request.getParameter("street");
				String zipcodestr = request.getParameter("zipcode");
				int zipcode = 0;
				if(zipcodestr != null){
					zipcode = Integer.parseInt(zipcodestr);
				}
				String city = request.getParameter("city");
				String department = request.getParameter("selectdeparment");
				String job = request.getParameter("selectjob");
				String salary = request.getParameter("salary");
				float salaryfl = 0f;
				if(salary != null){
					salaryfl = Float.parseFloat(salary);
				}
				
				Job j = null;
				if(job != null){
					long jobid = Long.parseLong(job);
					JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
					j = jobDAO.find(jobid);
				}
				
				Department de = null;
				if(department != null){
					long depid = Long.parseLong(department);
					DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance().getDepartmentDAO();
					de = departmentDAO.find(depid);
				}
				
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
				Employee employee = employeeDAO.find(id);
				
				if(name != null){
					employee.setSurname(name);
				}
				if(prename != null){
					employee.setPrename(prename);
				}
				if(street != null){
					employee.setStreet(street);
				}
				if(zipcode != 0){
					employee.setZipcode(zipcode);
				}
				if(city != null){
					employee.setCity(city);
				}
				if(salaryfl != 0f){
					employee.setSalary(salaryfl);
				}
				if(de != null){
					employee.setDepartment(de);
				}
				if(j != null){
					employee.setJob(j);
				}
	
				employeeDAO.update(employee);
				
				dispatcher = getServletContext().getRequestDispatcher("/EmployeeController?change="+id);
				
			}else if("1".equalsIgnoreCase(insert)){
				
				String name = request.getParameter("name");
				String prename = request.getParameter("prename");
				String street = request.getParameter("street");
				String zipcodestr = request.getParameter("zipcode");
				int zipcode = 0;
				if(zipcodestr.length()>0){
					zipcode = Integer.parseInt(zipcodestr);
				}
				String city = request.getParameter("city");
				String department = request.getParameter("selectdeparment");
				String job = request.getParameter("selectjob");
				String salary = request.getParameter("salary");
				float salaryfl = 0f;
				if(salary.length()>0){
					salaryfl = Float.parseFloat(salary);
				}
				
				Job j = null;
				if(job != null){
					long jobid = Long.parseLong(job);
					JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
					j = jobDAO.find(jobid);
				}
				
				Department de = null;
				if(department != null){
					long depid = Long.parseLong(department);
					DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance().getDepartmentDAO();
					de = departmentDAO.find(depid);
				}
				
				EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
				Employee employee = EmployeeFactory.getInstance().getEmployee();
				
				if(name != null){
					employee.setSurname(name);
				}
				if(prename != null){
					employee.setPrename(prename);
				}
				if(street != null){
					employee.setStreet(street);
				}
				if(zipcode != 0){
					employee.setZipcode(zipcode);
				}
				if(city != null){
					employee.setCity(city);
				}
				if(salaryfl != 0f){
					employee.setSalary(salaryfl);
				}
				if(de != null){
					employee.setDepartment(de);
				}
				if(j != null){
					employee.setJob(j);
				}
	
				employeeDAO.insert(employee);
				
				dispatcher = getServletContext().getRequestDispatcher("/EmployeeController?change="+employee.getId());
				
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
