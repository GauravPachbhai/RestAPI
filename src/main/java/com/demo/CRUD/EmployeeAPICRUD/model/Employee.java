package com.demo.CRUD.EmployeeAPICRUD.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Table(name = "Employee")
public class Employee {
		
	public Employee() {
		
	}
		
	public Employee(Long empid, String emp_name, Float emp_slary, int emp_age, String emp_city) {
		super();
		this.empid = empid;
		this.emp_name = emp_name;
		this.emp_slary = emp_slary;
		this.emp_age = emp_age;
		this.emp_city = emp_city;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long empid;
		
		@Column(name ="emp_name")
		private String emp_name;
		
		@Column(name ="emp_slary")
		private Float emp_slary;
		
		@Column(name ="emp_age")
		private int emp_age;
		
		@Column(name ="emp_city")
		private String emp_city;
		
		
		public Long getEmpid() {
			return empid;
		}

		public void setEmpid(Long empid) {
			this.empid = empid;
		}

		public String getEmp_name() {
			return emp_name;
		}

		public void setEmp_name(String emp_name) {
			this.emp_name = emp_name;
		}

		public Float getemp_slary() {
			return emp_slary;
		}

		public void setemp_slary(Float emp_slary) {
			this.emp_slary = emp_slary;
		}

		public int getEmp_age() {
			return emp_age;
		}

		public void setEmp_age(int emp_age) {
			this.emp_age = emp_age;
		}

		public String getEmp_city() {
			return emp_city;
		}

		public void setEmp_city(String emp_city) {
			this.emp_city = emp_city;
		}

		@Override
		public String toString() {
			return "Employee [empid=" + empid + ", emp_name=" + emp_name + ", emp_salary=" + emp_slary + ", emp_age="
					+ emp_age + ", emp_city=" + emp_city + "]";
		}
		
		
		
}



