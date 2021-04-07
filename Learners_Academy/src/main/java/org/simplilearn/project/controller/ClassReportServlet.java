package org.simplilearn.project.controller;

import java.io.IOException;
import org.simplilearn.project.service.ClassService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.simplilearn.project.model.Class;

@WebServlet("/classreport")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassReportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int classId = Integer.valueOf(request.getParameter("classId"));

		ClassService classService = new ClassService();
		Class tempClass = classService.findById(classId);

		request.setAttribute("class", tempClass);
		RequestDispatcher rd = request.getRequestDispatcher("/classReport.jsp");
		rd.forward(request, response);
	}
}
