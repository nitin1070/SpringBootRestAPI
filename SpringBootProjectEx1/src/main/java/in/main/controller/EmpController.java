package in.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.main.entity.Emp;
import in.main.service.EmpService;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
	private EmpService empService;
  @Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
   @GetMapping("/{empId}")
	public Emp getEmp(@PathVariable("empId") Integer empId) {
	   return empService.getEmp(empId);
   }
 
    @PostMapping("/add")
    public String addEmp(@RequestBody Emp emp) {
    	return empService.addEmp(emp);
    }
    @PutMapping("/update")
    public String updateEmp(Emp emp,Integer empId) {
    	return empService.updateEmp(emp, empId);
    }
	

}
