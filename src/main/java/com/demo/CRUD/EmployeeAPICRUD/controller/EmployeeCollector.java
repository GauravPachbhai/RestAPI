package com.demo.CRUD.EmployeeAPICRUD.controller;


import com.demo.CRUD.EmployeeAPICRUD.model.Employee;
import com.demo.CRUD.EmployeeAPICRUD.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeCollector {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public String createNewEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Employee Created in Datacbase";
    }
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
    	List<Employee> empList = new ArrayList<>();
    	employeeRepository.findAll().forEach(empList::add);
    	return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
    }
    
    @GetMapping("/employees/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
    	Optional<Employee> emp = employeeRepository.findById(empid);
    	if(emp.isPresent()){
    		return new ResponseEntity<Employee> (emp.get(),HttpStatus.FOUND);
    	}else {
    		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @PutMapping("/employees/{empid}")
    public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
    	Optional<Employee> emp = employeeRepository.findById(empid);
    	if(emp.isPresent()) {
    		Employee existEmp = emp.get();
    		existEmp.setEmp_age(employee.getEmp_age());
    		existEmp.setEmp_city(employee.getEmp_city());
    		existEmp.setEmp_name(employee.getEmp_name());
    		existEmp.setemp_slary(employee.getemp_slary());
    		employeeRepository.save(existEmp);
    		return "Employee Details against Id" + empid+ "Update";
    	}else {
    		return "Employee Details Does Not Exist"+ empid;
    	}
    }
    
    @DeleteMapping("/employees/{empid}")
    public String deletEmployeeById(@PathVariable long empid) {
    	employeeRepository.deleteById(empid);
    	return "Employee Deleted Successfully";
    }
    
    @DeleteMapping("/employees")
    public String deleteAllEmployess() {
    	employeeRepository.deleteAll();
    	return "All Employees Deleted Successfully";
    }
    
    

}
