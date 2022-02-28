package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("giuseppe")
public class Studente implements Person {

	private String name;
	private Exam exam;
	
	@Autowired
	public Studente(Exam exam) {
		this.exam = exam;
	}

	public String getName() {
		return name;
	}

	public Exam getExam() {
		return exam;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void sayHello() {
		System.out.print("Mi chiamo " + name + " e ho fatto l'esame di ");
		exam.method1();
	}

}