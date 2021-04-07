package org.simplilearn.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import org.simplilearn.project.model.Class;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.simplilearn.project.model.Student;
import org.simplilearn.project.service.StudentService;

@WebServlet(urlPatterns = { "/student/*" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentService();

	public StudentServlet() {
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
			case "/student/new":
				showNewForm(request, response);
				break;
			case "/student/insert":
				System.out.println("insert invoked");
				insertStudent(request, response);
				break;
			case "/student/delete":
				deleteStudent(request, response);
				break;
			case "/student/edit":
				System.out.println("edit invoked");
				showEditForm(request, response);
				break;
			case "/student/update":
				System.out.println("update called");
				updateStudent(request, response);
				break;
			case "/student/list":
				listStudent(request, response);
				break;
			default:
				studentPanel(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void studentPanel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentPanel.jsp");
		dispatcher.include(request, response);
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listStudent = studentService.getAllStudent();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentList.jsp");
		dispatcher.forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int classId = Integer.valueOf(request.getParameter("classId"));
		Class c = new Class();
		c.setId(classId);
		System.out.println("update method called");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String first_name = request.getParameter("firstName");
		System.out.println("firstName called in update" + first_name);
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student student = new Student(id, first_name, last_name, email, c);
		studentService.updateStudent(student);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentService.getStudent(id);
		int selectedOption = existingStudent.foreignClass.id;
		request.setAttribute("selectedOption", selectedOption);
		request.setAttribute("student", existingStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentForm.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		studentService.deleteStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentList.jsp");
		dispatcher.include(request, response);
		out.println(
				"<center><br><span style = 'color: blue; font-family: Helvetica, sans-serif;'>Deleted Successfully!</span></center><br><br><br>");

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		int classId = Integer.valueOf(request.getParameter("classId"));
		Class c = new Class();
		c.setId(classId);
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student student = new Student(first_name, last_name, email, c);
		studentService.saveStudent(student);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/studentForm.jsp");
		rd.include(request, response);
		out.println(
				"<center><br><span style = 'margin: 40px; color: #17b917; font-family: Helvetica, sans-serif;'>Added Successfully!</span></center>");

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("/studentForm.jsp");
		rd.forward(request, response);
	}

}
