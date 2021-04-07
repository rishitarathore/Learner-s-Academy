package org.simplilearn.project.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.project.model.Class;
import org.simplilearn.project.utils.HibernateUtil;

public class ClassService {

	public void saveClass(Class c) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());

		}

	}

	public void updateClass(Class c) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.update(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public void deleteClass(int id) {

		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Class c = session.get(Class.class, id);
			if (c != null) {
				session.delete(c);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
	}

	public Class getClass(int id) {

		Transaction transaction = null;
		Class c = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			c = session.get(Class.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return c;
	}

	public Class findById(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Class loadedClass = (Class) session.get(Class.class, id);
		session.getTransaction().commit();

		return loadedClass;
	}

	@SuppressWarnings("unchecked")
	public List<Class> getAllClass() {

		Transaction transaction = null;
		List<Class> listOfClass = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			listOfClass = session.createQuery("From Class").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(e.getMessage());
		}
		return listOfClass;
	}
}
