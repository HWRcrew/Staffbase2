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
		
		RequestDispatcher dispatcher = null;
		String insert = request.getParameter("insert");
		String change = request.getParameter("change");
		
		if(change != null){
			dispatcher = getServletContext().getRequestDispatcher("/settings_position_editable.jsp");
		}else if("1".equalsIgnoreCase(insert)){

			String name = request.getParameter("name");
			String salarystring = request.getParameter("salary");
			String description = request.getParameter("description");
			float salary = Float.parseFloat(salarystring);
			
			JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
			Job job = JobFactory.getInstance().getJob();
			
			job.setDescription(description);
			job.setName(name);
			job.setSalary(salary);
			
			jobDAO.insert(job);
			
			
			dispatcher = getServletContext().getRequestDispatcher("/JobController?change="+job.getId());
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

}
