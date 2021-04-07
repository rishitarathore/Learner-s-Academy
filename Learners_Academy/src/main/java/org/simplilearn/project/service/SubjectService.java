package org.simplilearn.project.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.simplilearn.project.model.Subject;
import org.simplilearn.project.utils.HibernateUtil;

public class SubjectService {

	public void saveSubject(Subject subject) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());

		}

	}

	public void updateSubject(Subject subject) {
		System.out.println("updateddddddd");
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.update(subject);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public void deleteSubject(int id) {

		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Subject subject = session.get(Subject.class, id);
			if (subject != null) {
				session.delete(subject);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public Subject getSubject(int id) {

		Transaction transaction = null;
		Subject subject = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			subject = session.get(Subject.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return subject;
	}

	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubject() {

		Transaction transaction = null;
		List<Subject> listOfSubject = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			listOfSubject = session.createQuery("From Subject").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return listOfSubject;
	}

}
