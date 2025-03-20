package in.main.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.main.model.ErrorResponse;
import in.main.model.Student;

@RestController
public class StudentController {
	@GetMapping("/student")
	public Student getStudent() {
		Student s=new Student(101,"Karan",23,"Spring Boot");
		return s;
	}
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student>studentList=List.of(new Student(101,"Karan",23,"Spring Boot"),new Student(102,"Deepak",22,"React"),new Student(103,"Arjun",25,"Gen AI"));
		return studentList;
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
		Map<Integer,Student>studentMap=Map.of(101,new Student(101,"Karan",23,"Spring Boot"),102,new Student(102,"Deepak",22,"React"),103,new Student(103,"Arjun",25,"Gen AI"));
		Student s=studentMap.get(id);
		if(s==null) {
			ErrorResponse obj=new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Student ID "+id+" not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
		}
		return ResponseEntity.ok(s);
	}
	@GetMapping("/students/{id}/{name}")
	public ResponseEntity<?> getStudentByIdAndName(@PathVariable Integer id,@PathVariable String name){
		Map<Integer,Student>studentMap=Map.of(101,new Student(101,"Karan",23,"Spring Boot"),102,new Student(102,"Deepak",22,"React"),103,new Student(103,"Arjun",25,"Gen AI"));
		Student s=studentMap.get(id);
		if(s==null || !s.getName().equals(name)) {
			ErrorResponse obj=new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Student not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
		}
		return ResponseEntity.ok(s);
	}
	@GetMapping("/students/info")
	public ResponseEntity<?> findStudentByIdAndName(@RequestParam Integer id,@RequestParam String name){
		Map<Integer,Student>studentMap=Map.of(101,new Student(101,"Karan",23,"Spring Boot"),102,new Student(102,"Deepak",22,"React"),103,new Student(103,"Arjun",25,"Gen AI"));
		Student s=studentMap.get(id);
		if(s==null || !s.getName().equals(name)) {
			ErrorResponse obj=new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Student not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
		}
		return ResponseEntity.ok(s);
	}

}
