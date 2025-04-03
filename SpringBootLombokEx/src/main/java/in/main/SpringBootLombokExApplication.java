package in.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.main.dto.Student;
import in.main.dto.User;

@SpringBootApplication
public class SpringBootLombokExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLombokExApplication.class, args);
		
		
		  User user1 = new User("Nitin",20); User user2 = new User("Nitin",20); User
		  user3 = new User(); user3.setName("Soumya"); user3.setAge(20);
		  System.out.println(user3.getName()+"\n"+user3.getAge());
		  System.out.println(user1); System.out.println(user1==user2);
		  System.out.println(user1.equals(user2));
		 
		 
		
		/* =============== For Student class ================== */
		
		Student student = new Student();
		Student student2 = new Student("Sakhi",65);
		System.out.println(student2);
		student.setName("Divay");
		student.setAge(25);
		System.out.println("Student name : " +student.getName()+"\n Student Age "+student.getAge());
		
	}

}
