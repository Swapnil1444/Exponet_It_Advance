
package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aId;

    private String adharNo;

    @OneToOne(mappedBy = "adhar")
    private Person person;

    // Default constructor
    public Adhar() {
    }

    // Getters and Setters
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Display only Aadhaar information
    public void getAdharOnly() {
        System.out.println("======================================");
        System.out.println("         AADHAAR INFORMATION");
        System.out.println("======================================");
        System.out.println("Aadhaar ID  : " + aId);

        // Mask Aadhaar number for privacy
        if (adharNo != null && adharNo.length() >= 4) {
            System.out.println("Aadhaar No  : XXXX-XXXX-"
                    + adharNo.substring(adharNo.length() - 4));
        } else {
            System.out.println("Aadhaar No  : Not available");
        }

        System.out.println("======================================");
    }

    @Override
    public String toString() {
        return "Adhar {" +
                "aId=" + aId +
                ", adharNo='"
                + (adharNo != null && adharNo.length() >= 4
                    ? "XXXX-XXXX-" + adharNo.substring(adharNo.length() - 4)
                    : "Not available")
                + '\'' +
                '}';
    }
}
