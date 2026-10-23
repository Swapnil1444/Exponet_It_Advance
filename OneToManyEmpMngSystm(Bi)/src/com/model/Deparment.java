
package com.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Deparment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;

    private String dName;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
		return "\nDeparment [dId=" + dId + ",dName=" + dName + ", \n emps=" + emps + "]";
	}
    
    
}
