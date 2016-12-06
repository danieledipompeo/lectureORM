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
		
		Address address = new Address("OMR Road", "Chennai", "TN", "600097");
		
		try {
			transaction = session.beginTransaction();
			
			Person person = new Person();
			person.setName("Mike");
			session.save(person);
			
			Transcript transcript1 = new Transcript("swr12");
			Student student1 = new Student("Eswar", transcript1, null, null);
			Transcript transcript2 = new Transcript("dnl21");
			Student student2 = new Student("Daniel", transcript2, null, null);
			session.save(student1);
			session.save(student2);
			
			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("Maths"));
			courses.add(new Course("Computer Science"));

			Criteria criteria = session.createCriteria(Student.class);
			List<Student> students = (List<Student>) criteria.list();
			
			for(Student student : students){
				Phone house = new Phone("house","32354353", student);
				session.save(house);
				Phone mobile = new Phone("mobile","32354353", student);
				session.save(mobile);
				student.setCourses(courses);
				student.setPersonAddress(address);
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
