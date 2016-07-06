package com.techm.cadt.cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = Employee.FIND_ALL, query = "SELECT c FROM Employee c ORDER BY c.name ASC"),
    @NamedQuery(name = Employee.FIND_BY_NAME, query = "SELECT c FROM Employee c WHERE c.name = :name")
})

@Table(name = "Employee")
public class Employee {

    public static final String FIND_ALL = "Contact.findAll";
    public static final String FIND_BY_NAME = "Contact.findByName";

    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_salary")
	private double salary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

}
