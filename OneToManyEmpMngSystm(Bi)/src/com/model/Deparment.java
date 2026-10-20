package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Deparment {

	private int dId;
	private String dName;
	
	@OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
	private List<Employee> emps;

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Deparment [dId=" + dId + ", dName=" + dName + ", emps=" + emps + "]";
	}
	
	
}
