package student;

import java.util.List;
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
			Address address = new Address("OMR Road", "Chennai", "TN", "600097");
			for(Student student : students){
				student.setStudentAddress(address);
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
