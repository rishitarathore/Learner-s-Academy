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
import org.simplilearn.project.model.Teacher;
import org.simplilearn.project.service.TeacherService;

@WebServlet(urlPatterns = { "/teacher/*" })
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService teacherService = new TeacherService();

	public TeacherServlet() {
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
			case "/teacher/new":
				showNewForm(request, response);
				break;
			case "/teacher/insert":
				System.out.println("insert invoked");
				insertTeacher(request, response);
				break;
			case "/teacher/delete":
				deleteTeacher(request, response);
				break;
			case "/teacher/edit":
				System.out.println("edit invoked");
				showEditForm(request, response);
				break;
			case "/teacher/update":
				System.out.println("update called");
				updateTeacher(request, response);
				break;
			case "/teacher/list":
				listTeacher(request, response);
				break;
			default:
				teacherPanel(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void teacherPanel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherPanel.jsp");
		dispatcher.include(request, response);
	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Teacher> listTeacher = teacherService.getAllTeacher();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherList.jsp");
		dispatcher.forward(request, response);
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		System.out.println("update method called");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String first_name = request.getParameter("firstName");
		System.out.println("firstName called in update" + first_name);
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		Teacher teacher = new Teacher(id, first_name, last_name, email);
		teacherService.updateTeacher(teacher);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Teacher existingTeacher = teacherService.getTeacher(id);
		request.setAttribute("teacher", existingTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherForm.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {

		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		teacherService.deleteTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacherList.jsp");
		dispatcher.include(request, response);
		out.println(
				"<center><br><span style = 'color: blue; font-family: Helvetica, sans-serif;'>Deleted Successfully!</span></center><br><br><br>");

	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		Teacher teacher = new Teacher(first_name, last_name, email);
		teacherService.saveTeacher(teacher);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/teacherForm.jsp");
		rd.include(request, response);
		out.println(
				"<center><br><span style = 'margin: 40px; color: #17b917; font-family: Helvetica, sans-serif;'>Added Successfully!</span></center>");

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/teacherForm.jsp");
		rd.forward(request, response);
	}

}
