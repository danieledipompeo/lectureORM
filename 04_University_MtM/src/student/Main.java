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

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Set<Course> courses = new HashSet<Course>();
			Course math = new Course("Maths");
			Course cs = new Course("Computer Science");
			session.save(math);
			session.save(cs);
			courses.add(math);
			courses.add(cs);
			

			Criteria criteria = session.createCriteria(Student.class);
			List<Student> students = (List<Student>) criteria.list();
			
			for(Student student : students){
				student.setCourses(courses);
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
