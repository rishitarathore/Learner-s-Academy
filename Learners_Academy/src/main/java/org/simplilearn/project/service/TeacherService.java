package org.simplilearn.project.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.simplilearn.project.model.Teacher;
import org.simplilearn.project.utils.HibernateUtil;

public class TeacherService {

	public void saveTeacher(Teacher teacher) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());

		}

	}

	public void updateTeacher(Teacher teacher) {
		System.out.println("updateddddddd");
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.update(teacher);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public void deleteTeacher(int id) {

		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, id);
			if (teacher != null) {
				session.delete(teacher);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public Teacher getTeacher(int id) {

		Transaction transaction = null;
		Teacher teacher = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return teacher;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeacher() {

		Transaction transaction = null;
		List<Teacher> listOfTeacher = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			listOfTeacher = session.createQuery("From Teacher").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return listOfTeacher;
	}

}
