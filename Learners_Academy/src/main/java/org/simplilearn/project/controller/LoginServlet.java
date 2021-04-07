package org.simplilearn.project.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (userName.equals("a") && password.equals("a")) {
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);

		} else {

			request.getRequestDispatcher("index.jsp").include(request, response);
			out.println(
					"<center><br><span style = 'color: #E32020; font-family: Helvetica, sans-serif;'>Invalid Credentials!</span></center>");
		}

		out.close();
	}

}
