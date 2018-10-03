package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

import io.swagger.annotations.Api;

@RestController
@Api
public class EmpRestController {
	@Autowired
	EmpRepository repo;

	@RequestMapping(path = "/greet", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String greetWithRest() {
		return "Welcome to Spring Rest";
	}

	@RequestMapping(path = "/emp/find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Emp findOne(@PathVariable("id") int id) {
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new RuntimeException("No Emp Found");
		}
	}

	@RequestMapping(path = "/emp/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> saveToDb(@RequestBody Emp e) {
		if (repo.existsById(e.getEmpid())) {
			return ResponseEntity.ok("{\"status\":\"Emp Exists\"}");
		} else {
			Emp e1 = repo.save(e);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	}

	@GetMapping(path = "/emp/list", produces = "application/json")
	public List<Emp> getAll() {
		return repo.findAll();
	}
	
	@DeleteMapping(path="/emp/delete",produces="text/plain")
	public String deleteEmp(@RequestParam("id")int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Data Deleted";
			
		}else {
			return "Emp does not exist";
		}
	}
}
