package de.hwr.staffbase2.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

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

/**
 * Servlet implementation class LoginController
 * @author leroyhoebold
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	private void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		boolean correct = false;
		boolean isManager = false;
		
		if(request.getSession().getAttribute("saved_login")!= null && request.getSession().getAttribute("username")!= null && request.getSession().getAttribute("manager") != null){
			long milli = 0;
			boolean sessionmanager;
			milli = (Long) request.getSession().getAttribute("saved_login");
			sessionmanager = (Boolean) request.getSession().getAttribute("manager");
			Calendar time = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
			if(time.getTimeInMillis()-milli<3600000){
				correct = true;
				isManager = sessionmanager;
			}else{
				request.getSession().removeAttribute("saved_login");
				request.getSession().removeAttribute("username");
				request.getSession().removeAttribute("manager");
			}
		}else{
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			
			if(username != null && password != null){
				AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
				Account account = AccountFactory.getInstance().getAccount();
				account = accountDAO.find(username, password);
				if(account != null){
					
					boolean dbmanager = account.isManager();
					if(dbmanager){
						isManager = true;
					}else{
						isManager = false;
					}
			
					Calendar time2 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
					long milli2 = time2.getTimeInMillis();
					request.getSession().setAttribute("saved_login", milli2);
					request.getSession().setAttribute("username", username);
					request.getSession().setAttribute("manager", dbmanager);
					correct = true;				
				}
			}
		}
	
		RequestDispatcher dispatcher = null;

		

		if(correct && isManager){
			System.out.println("User und PW Kombi existiert und ist Manager");
			dispatcher = getServletContext().getRequestDispatcher("/settings.jsp");
			dispatcher.forward(request, response);
		}else if(correct && !isManager){
			System.out.println("User und PW Kombi existiert und ist kein Manager");
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}else{
			System.out.println("User und PW Kombi existiert nicht");
			dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
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
