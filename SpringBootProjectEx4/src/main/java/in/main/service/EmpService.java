package in.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import in.main.entity.Emp;
import in.main.exception.EmpAlreadyExistException;
import in.main.exception.NoSuchEmpExistException;
import in.main.reposistory.EmpRepo;

@Service
public class EmpService {
	private EmpRepo empRepo;
    @Autowired
	public EmpService(EmpRepo empRepo) {
		this.empRepo = empRepo;
	}


    public String addEmp(Emp emp) {
    	Emp e = empRepo.findByName(emp.getName()).orElse(null);
    	if(e!=null) {
    		throw new EmpAlreadyExistException("Emp with name "+emp.getName()+" already exist");
    	}
         empRepo.save(emp);
		return "emp added successfully";
		
    }
	
	public Emp getEmp(Integer empId) {
		Emp e = empRepo.findById(empId).orElse(null);
		if(e==null) {
			throw new NoSuchEmpExistException("Empt wiht id " + empId+" not found");
		}
		return e;

	}
	public String updateEmp(Emp updatedEmp,Integer empId) {
		Emp e = empRepo.findById(empId).orElse(null);
		if(e==null) {
			throw new NoSuchEmpExistException("Empt wiht id " + empId+" not found");
		}
		e.setName(updatedEmp.getName());
		e.setAge(updatedEmp.getAge());
		empRepo.save(e);
		return "Emp with id "+empId+" updated successfully ";
		
	}
	
	
	

}
