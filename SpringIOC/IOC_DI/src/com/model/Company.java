package com.model;

public class Company {
	
	private int Compid;
	private String Compname;
	public int getCompid() {
		return Compid;
	}
	public void setCompid(int compid) {
		Compid = compid;
	}
	public String getCompname() {
		return Compname;
	}
	public void setCompname(String compname) {
		Compname = compname;
	}
	@Override
	public String toString() {
		return "Company [Compid=" + Compid + ", Compname=" + Compname + "]";
	}
	

	
	

}
