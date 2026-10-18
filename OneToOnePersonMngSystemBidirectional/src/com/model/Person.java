
package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    private String pName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Adhar_Id")
    private Adhar adhar;

    // Default constructor
    public Person() {
    }

    // Getters and Setters
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Adhar getAdhar() {
        return adhar;
    }

    public void setAdhar(Adhar adhar) {
        this.adhar = adhar;
    }

    // Display only Person information
    public void getPersonOnly() {
        System.out.println("==================================");
        System.out.println("       PERSON INFORMATION");
        System.out.println("==================================");
        System.out.println("Person ID   : " + pId);
        System.out.println("Person Name : " + pName);
        System.out.println("==================================");
    }

    // Display complete Person information
    @Override
    public String toString() {
        return "Person {" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", adhar=" + adhar +
                '}';
    }
}
