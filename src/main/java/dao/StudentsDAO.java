package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Student;

public class StudentsDAO {
	private final EntityManager em;

	public StudentsDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Student s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
		System.out.println("Studente salvato");
		// Termina la transazione ed effettua il flush dell'oggetto
		// Effettuare il flush significa quindi persistere ciò che c'è
		// nel Persistence Context nel db
	}

	public Student findById(long id) {
		// Query q = em.createNativeQuery("SELECT blablabla");
		Student found = em.find(Student.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {
		Student found = em.find(Student.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Studente con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Student found = em.find(Student.class, id);
		found.setFirstName("Giovanni");
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}

}
