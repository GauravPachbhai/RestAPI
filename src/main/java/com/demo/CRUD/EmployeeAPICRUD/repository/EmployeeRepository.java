package com.demo.CRUD.EmployeeAPICRUD.repository;


import com.demo.CRUD.EmployeeAPICRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
