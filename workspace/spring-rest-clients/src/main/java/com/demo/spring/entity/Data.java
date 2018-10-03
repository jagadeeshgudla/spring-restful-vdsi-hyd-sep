package com.demo.spring.entity;

public class Data {
	private int empid;
	private String name;
	private String city;
	private double salary;

	public Data() {
		
	}

	
	public Data(int empid, String name, String city, double salary) {
		this.empid = empid;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}


	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
