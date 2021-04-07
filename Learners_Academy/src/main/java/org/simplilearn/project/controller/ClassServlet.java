package org.simplilearn.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.simplilearn.project.model.Class;
import org.simplilearn.project.service.ClassService;

@WebServlet(urlPatterns = { "/class/*" })
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassService classService = new ClassService();

	public ClassServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		String pathInfo = request.getPathInfo();

		System.out.println("Path == " + path);
		System.out.println("Path info == " + pathInfo);
		System.out.println("-----------------------------------------");

		try {
			switch (path) {
			case "/class/new":
				showNewForm(request, response);
				break;
			case "/class/insert":
				insertClass(request, response);
				break;
			case "/class/delete":
				deleteClass(request, response);
				break;
			case "/class/edit":
				showEditForm(request, response);
				break;
			case "/class/update":
				updateClass(request, response);
				break;
			case "/class/list":
				listClass(request, response);
				break;
			default:
				classPanel(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void classPanel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("class Panel");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classPanel.jsp");
		dispatcher.forward(request, response);
	}

	private void listClass(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Class> listClass = classService.getAllClass();
		request.setAttribute("listClass", listClass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classList.jsp");
		dispatcher.forward(request, response);
	}

	private void updateClass(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Class c = new Class(id, name);
		classService.updateClass(c);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Class existingClass = classService.getClass(id);
		request.setAttribute("c", existingClass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classForm.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id + "delete ");
		classService.deleteClass(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classList.jsp");
		dispatcher.include(request, response);
		out.println(
				"<center><br><span style = 'color: blue; font-family: Helvetica, sans-serif;'>Deleted Successfully!</span></center><br><br><br>");
	}

	private void insertClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		String name = request.getParameter("name");
		Class c = new Class(name);
		classService.saveClass(c);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/classForm.jsp");
		rd.include(request, response);
		out.println(
				"<center><br><span style = 'margin: 40px; color: #17b917; font-family: Helvetica, sans-serif;'>Added Successfully!</span></center>");

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/classForm.jsp");
		rd.forward(request, response);
	}

}
