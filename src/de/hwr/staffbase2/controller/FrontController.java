package de.hwr.staffbase2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */

//TODO FrontController Pattern anwenden
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			java.io.IOException {
		response.setContentType("text/html;charset=UTF-8");
		String next;
		// TODO RequestHandler?

		try {
			// Use a helper object to gather parameter
			// specific information.
			RequestHelper helper = new RequestHelper(request, response);

			// Get command object helper
			Command command = helper.getCommand();
			// delegate processing to the command object,
			// passing request and response objects along
			next = command.execute(helper);

			/**
			 * If the above command returns a value, we will dispatch from the
			 * controller. In this example, though, the command will use a
			 * separate dispatcher component to choose a view and dispatch to
			 * that view. The command object delegates to this dispatcher
			 * component in its execute method, above, and control should not
			 * return to this point
			 **/
		} catch (Exception e) {

			/**
			 * ApplicationResources provides a simple API for retrieving
			 * constants and other preconfigured values
			 **/
			next = ApplicationResources.getInstance().getErrorPage(e);
		}

		dispatch(request, response, next);

	}

	protected void dispatch(HttpServletRequest request,
			HttpServletResponse response, String page)
			throws javax.servlet.ServletException, java.io.IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
