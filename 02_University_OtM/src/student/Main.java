package student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Student.class);
			List<Student> students = (List<Student>) criteria.list();
			
			for(Student student : students){
				//Set<Phone> phoneNumbers = new HashSet<Phone>();
				Phone house = new Phone("house","32354353", student);
				session.save(house);
				Phone mobile = new Phone("mobile","32354353", student);
				session.save(mobile);
				session.save(student);
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
