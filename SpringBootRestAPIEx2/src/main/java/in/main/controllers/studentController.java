package in.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.model.Student;

@RestController
public class studentController {
	@GetMapping("/student")
    public Student showStudent() {
		Student student=new Student(101,"Nitin",23,"SpringBoot");
		return student;
		
    }
	
	
	@GetMapping("/students")
    public List<Student> showStudents() {
	java.util.List<Student> studentList = new ArrayList<>();
		
		Student student=new Student(101,"Nitin",23,"SpringBoot");
		Student student1=new Student(102,"Deepanshu",22,"Java");
		Student student2=new Student(103,"Divya",25,"JavaScript");
		Student student3=new Student(104,"Sakshi",28,"Python");
		Student student4=new Student(104,"Sakshi",28,"Python");
	    studentList.add(student);
	    studentList.add(student1);
	    studentList.add(student2);
	    studentList.add(student3);
	    studentList.add(student4);
		return studentList;
		
    }
	
	
}
