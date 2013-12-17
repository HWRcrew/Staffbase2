package de.hwr.staffbase2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hwr.staffbase2.model.Job;
import de.hwr.staffbase2.model.JobDAO;
import de.hwr.staffbase2.model.JobDAOFactory;
import de.hwr.staffbase2.model.JobFactory;

/**
 * Servlet implementation class JobController
 */
@WebServlet("/JobController")
public class JobController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = null;
		String insert = request.getParameter("insert");
		String change = request.getParameter("change");
		
		if(change != null){
			dispatcher = getServletContext().getRequestDispatcher("/settings_position_editable.jsp");
		}else if("1".equalsIgnoreCase(insert)){

			String name = request.getParameter("name");
			String salarystring = request.getParameter("salary");
			String description = request.getParameter("description");
			
			
			if(checkValues(name, salarystring, description)){
				float salary = 0;
				try{
					salary = Float.parseFloat(salarystring);
				}catch(Exception e){
					request.setAttribute("errorMessage", "Inkorrekte Eingabe: In dem Feld Gehalt muss eine Zahl sein.");
					request.setAttribute("name", name);
					request.setAttribute("description", description);
					dispatcher = getServletContext().getRequestDispatcher("/JobController?change=");
					dispatcher.forward(request, response);
					return;
				}
			
			
							
			JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
			Job job = JobFactory.getInstance().getJob();
			
			job.setDescription(description);
			job.setName(name);
			job.setSalary(salary);
			
			jobDAO.insert(job);
			
			
			dispatcher = getServletContext().getRequestDispatcher("/JobController?change="+job.getId());
			
			}else{
				request.setAttribute("errorMessage", "Inkorrekte Eingabe: Alle Pflichtfelder müssen eingetragen sein.");
				request.setAttribute("name", name);
				request.setAttribute("description", description);
				request.setAttribute("salary", salarystring);
				dispatcher = getServletContext().getRequestDispatcher("/JobController?change=");
			}
			
		}else{
			dispatcher = getServletContext().getRequestDispatcher("/tables_position.jsp");
		}
		
		
		dispatcher.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handle(request,response);
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
