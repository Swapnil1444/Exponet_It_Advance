package com.model;

public class Department {

	private int Deptid;
	private String Deptname;
	
	private Company company;

	public int getDeptid() {
		return Deptid;
	}

	public void setDeptid(int deptid) {
		Deptid = deptid;
	}

	public String getDeptname() {
		return Deptname;
	}

	public void setDeptname(String deptname) {
		Deptname = deptname;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Department [Deptid=" + Deptid + ", Deptname=" + Deptname + ", company=" + company + "]";
	}

	
	
}
