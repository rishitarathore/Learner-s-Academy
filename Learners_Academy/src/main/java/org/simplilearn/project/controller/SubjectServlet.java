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
import org.simplilearn.project.model.Subject;
import org.simplilearn.project.model.Teacher;
import org.simplilearn.project.service.SubjectService;

@WebServlet(urlPatterns = { "/subject/*" })
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectService subjectService = new SubjectService();

	public SubjectServlet() {
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
			case "/subject/new":
				showNewForm(request, response);
				break;
			case "/subject/insert":
				System.out.println("insert invoked");
				insertSubject(request, response);
				break;
			case "/subject/delete":
				deleteSubject(request, response);
				break;
			case "/subject/edit":
				System.out.println("edit invoked");
				showEditForm(request, response);
				break;
			case "/subject/update":
				System.out.println("update called");
				updateSubject(request, response);
				break;
			case "/subject/list":
				listSubject(request, response);
				break;
			default:
				subjectPanel(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void subjectPanel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectPanel.jsp");
		dispatcher.include(request, response);
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Subject> listSubject = subjectService.getAllSubject();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectList.jsp");
		dispatcher.forward(request, response);
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int classId = Integer.valueOf(request.getParameter("classId"));
		Class c = new Class();
		c.setId(classId);
		int teacherId = Integer.valueOf(request.getParameter("teacherId"));
		Teacher t = new Teacher();
		t.setId(teacherId);
		System.out.println("update method called");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		Subject subject = new Subject(id, name, code, t, c);
		subjectService.updateSubject(subject);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Subject existingSubject = subjectService.getSubject(id);
		int selectedOption1 = existingSubject.foreignClass.id;
		request.setAttribute("selectedOption1", selectedOption1);
		Integer selectedOption2 = existingSubject.foreignTeacher.id;
		request.setAttribute("selectedOption2", selectedOption2);
		request.setAttribute("subject", existingSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectForm.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		subjectService.deleteSubject(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/subjectList.jsp");
		dispatcher.include(request, response);
		out.println(
				"<center><br><span style = 'color: blue; font-family: Helvetica, sans-serif;'>Deleted Successfully!</span></center><br><br><br>");

	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		int classId = Integer.valueOf(request.getParameter("classId"));
		Class c = new Class();
		c.setId(classId);
		int teacherId = Integer.valueOf(request.getParameter("teacherId"));
		Teacher t = new Teacher();
		t.setId(teacherId);
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		Subject subject = new Subject(name, code, t, c);
		subjectService.saveSubject(subject);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/subjectForm.jsp");
		rd.include(request, response);
		out.println(
				"<center><br><span style = 'margin: 40px; color: #17b917; font-family: Helvetica, sans-serif;'>Added Successfully!</span></center>");

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/subjectForm.jsp");
		rd.forward(request, response);
	}

}
