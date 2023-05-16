package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.StudentsDAO;
import entities.Student;
import util.JpaUtil;

public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		logger.info("CIAO");
		EntityManager em = emf.createEntityManager();
		StudentsDAO sd = new StudentsDAO(em);

		// ************************ SAVE *********************
		Student aldo = new Student("Aldo", "Baglio", LocalDate.now());
		sd.save(aldo);

		// ************************ FIND BY ID *********************

		System.out.println(sd.findById(6));

		// ************************ DELETE *********************
		sd.findByIdAndDelete(6);
		
		// ************************ REFRESH ********************
		sd.refresh(7);
		em.close();

		emf.close();

	}

}
