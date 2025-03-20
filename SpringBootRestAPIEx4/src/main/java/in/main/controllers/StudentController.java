package in.main.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.main.model.Student;

@RestController
public class StudentController {
	private Map<Integer, Student>stMap;
	public StudentController() {
		stMap=new HashMap<>(Map.of(101,new Student(101,"Karan",23,"Spring Boot"),102,new Student(102,"Deepak",22,"React"),103,new Student(103,"Arjun",25,"Gen AI")));
	}
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student s) {
		s.setId(100+stMap.size()+1);
		stMap.put(s.getId(), s);
		return new ResponseEntity(s,HttpStatus.CREATED);
	}
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return stMap.get(id);
	}
	@PostMapping("/students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createNewStudent(@RequestBody Student s) {
		s.setId(100+stMap.size()+1);
		stMap.put(s.getId(), s);
		return s;
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student updatedStudent,@PathVariable Integer id) {
		Student existingStudent=stMap.get(id);
		if(existingStudent==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student ID:"+id+" not found");
		}
		existingStudent.setAge(updatedStudent.getAge());
		existingStudent.setName(updatedStudent.getName());
		existingStudent.setCourse(updatedStudent.getCourse());
		return ResponseEntity.ok(existingStudent);
		
	}
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable Integer id) {
		Student existingStudent=stMap.remove(id);
		if(existingStudent==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student ID:"+id+" not found");
		}
		return ResponseEntity.ok(existingStudent);
	}


}
