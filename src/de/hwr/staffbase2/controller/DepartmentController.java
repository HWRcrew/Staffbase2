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
import de.hwr.staffbase2.model.DepartmentFactory;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String change = request.getParameter("change");
		String update = request.getParameter("update");
		String insert = request.getParameter("insert");
		RequestDispatcher dispatcher = null;
		
		if(change != null){
			dispatcher = getServletContext().getRequestDispatcher("/settings_department_editable.jsp");
		}else if("1".equalsIgnoreCase(update)){
			String id = request.getParameter("_id");
			long idlong = Long.parseLong(id);
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			 DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance().getDepartmentDAO();
			 Department department = DepartmentFactory.getInstance().getDepartment();
			 
			 department.setId(idlong);
			 department.setName(name);
			 department.setDescription(description);
			 
			 departmentDAO.update(department);
			 
			 dispatcher = getServletContext().getRequestDispatcher("/DepartmentController?change="+id);
		}else if("1".equalsIgnoreCase(insert)){
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			 DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance().getDepartmentDAO();
			 Department department = DepartmentFactory.getInstance().getDepartment();
			 
			 department.setName(name);
			 department.setDescription(description);
			 
			 departmentDAO.insert(department);
			 
			 dispatcher = getServletContext().getRequestDispatcher("/DepartmentController?change="+department.getId());
		}else{
			dispatcher = getServletContext().getRequestDispatcher("/tables_department.jsp");
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
