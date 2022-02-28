package pack;

import org.springframework.stereotype.Component;

@Component
public class Math implements Exam {

	@Override
	public void method1() {
		System.out.println("Matematica");
	}
	
	
}
