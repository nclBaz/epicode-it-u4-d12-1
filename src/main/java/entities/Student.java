package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
public class Student {

	@Id
	@GeneratedValue // Obbligatorio usarlo se si vuol fare gestire gli id al db
	// private UUID id;
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

	public Student() {
	}

	public Student(String firstName, String lastName, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

}
