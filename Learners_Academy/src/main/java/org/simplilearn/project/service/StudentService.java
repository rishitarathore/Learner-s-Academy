package org.simplilearn.project.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.simplilearn.project.model.Student;
import org.simplilearn.project.utils.HibernateUtil;

public class StudentService {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());

		}

	}

	public void updateStudent(Student student) {
		System.out.println("updateddddddd");
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public void deleteStudent(int id) {

		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public Student getStudent(int id) {

		Transaction transaction = null;
		Student student = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return student;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {

		Transaction transaction = null;
		List<Student> listOfStudent = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			listOfStudent = session.createQuery("From Student").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return listOfStudent;
	}
}
