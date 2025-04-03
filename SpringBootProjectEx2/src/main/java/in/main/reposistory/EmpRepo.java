package in.main.reposistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.main.entity.Emp;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer> {
	  public Optional<Emp>findByName(String name);
	  public Optional<Emp>findById(Integer empId);
	  
 
}
