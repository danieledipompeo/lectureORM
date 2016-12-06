package student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Main test = new Main();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		Address address = new Address("OMR Road", "Chennai", "TN", "600097");

		try {
			transaction = session.beginTransaction();
			test.populateDB(session);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction2 = null;
		try {
			transaction2 = session2.beginTransaction();
			Criteria criteria = session2.createCriteria(Student.class);
			List<Student> students = (List<Student>) criteria.list();

			boolean first = false;
			for (Student student : students) {
				Phone house = new Phone("house","32354353", student);
				session2.save(house);
				Phone mobile = new Phone("mobile","32354353", student);
				session2.save(mobile);
				Set<Course> courses = new HashSet<Course>();
				courses.add(new BaseCourse("Maths"));
				courses.add(new BaseCourse("Computer Science"));
				courses.add(new EnglishAdvancedCourse("Advanced Software Engineering", false));

				if (first) {
					Course c = new ItalianAdvancedCourse("Calcolo delle probabilita", false);
					courses.add(c);
					student.setCourses(courses);
				}
				student.setPersonAddress(address);
				session2.save(student);
				first = true;
			}
			transaction2.commit();
		} catch (HibernateException e) {
			transaction2.rollback();
			e.printStackTrace();
		} finally {
			session2.close();
		}
		
		Session session4 = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria3 = session4.createCriteria(Transcript.class, "libretto");
			criteria3.createAlias("libretto.student", "student");
			criteria3.add(Restrictions.eq("student.name", "Eswar"));

			List<Transcript> transcripts = (List<Transcript>) criteria3.list();

			for (Transcript transcript : transcripts) {
				System.out.println(transcript.toString());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session4.close();
		}
	}

	@SuppressWarnings("unused")
	private void populateDB(Session session) {
		Person person = new Person();
		person.setName("Mike");
		session.save(person);
		Transcript transcript1 = new Transcript("swr12");
		Student student1 = new Student("Eswar", transcript1, null, null);
		transcript1.setStudent(student1);
		
		Transcript transcript2 = new Transcript("dnl21");
		Student student2 = new Student("Daniel", transcript2, null, null);
		transcript2.setStudent(student2);
		
		session.save(student1);
		session.save(student2);
	}
}
