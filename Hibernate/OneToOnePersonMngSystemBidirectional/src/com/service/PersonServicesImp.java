
package com.service;

import java.util.List;

import com.dao.AdharDAO;
import com.dao.PersonDAO;
import com.model.Adhar;
import com.model.Person;
import com.util.ValidetionUtil;

public class PersonServicesImp implements PersonServices {

    // 1. Add Person with Aadhaar
    @Override
    public void addPerson() {
        Person person = new Person();

        person.setpName(
            ValidetionUtil.validString("Enter Person Name: ")
        );

        Adhar adhar = new Adhar();

        adhar.setAdharNo(
            ValidetionUtil.ValidAdhar("Enter Aadhaar Number: ")
        );

        person.setAdhar(adhar);

        int id = PersonDAO.AddPerson(person);

        if (id != 0) {
            System.out.println("Person added successfully.");
            System.out.println("Generated Person ID: " + id);
        } else {
            System.out.println("Failed to add Person.");
        }
    }

    // 2. Get All Persons
    @Override
    public void getAll() {
        List<Person> pList = PersonDAO.getAll();

        if (pList != null && !pList.isEmpty()) {
            for (Person p : pList) {
                p.getPersonOnly();

                if (p.getAdhar() != null) {
                    p.getAdhar().getAdharOnly();
                }
            }
        } else {
            System.out.println("No Person records found.");
        }
    }

    // 3. Get Person Using Person ID
    @Override
    public void getPersonOnlyUsingPid() {
        int id = ValidetionUtil.validInt("Enter Person ID: ");

        Person p = PersonDAO.getPersonOnly(id);

        if (p != null) {
            p.getPersonOnly();
        } else {
            System.out.println("Person not found.");
        }
    }

    // 4. Get Aadhaar Using Person ID
    @Override
    public void getAdharOnlyUsingPid() {
        int id = ValidetionUtil.validInt("Enter Person ID: ");

        Person p = PersonDAO.getPersonOnly(id);

        if (p == null) {
            System.out.println("Person not found.");
            return;
        }

        if (p.getAdhar() != null) {
            p.getAdhar().getAdharOnly();
        } else {
            System.out.println("Aadhaar not found for this Person.");
        }
    }

    // 5. Update Person Using Person ID
    @Override
    public void updatePersonDetailsUsingPid() {
        int id = ValidetionUtil.validInt("Enter Person ID: ");

        Person p = PersonDAO.getPersonOnly(id);

        if (p != null) {
            p.setpName(
                ValidetionUtil.validString("Enter New Name: ")
            );

            PersonDAO.updatePerson(p);
            System.out.println("Person updated successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }

    // 6. Update Aadhaar Using Person ID
    @Override
    public void updateAdharDetailsUsingPid() {
        int id = ValidetionUtil.validInt("Enter Person ID: ");

        Person p = PersonDAO.getPersonOnly(id);

        if (p == null) {
            System.out.println("Person not found.");
            return;
        }

        if (p.getAdhar() != null) {
            p.getAdhar().setAdharNo(
                ValidetionUtil.ValidAdhar("Enter New Aadhaar Number: ")
            );

            PersonDAO.updatePerson(p);
            System.out.println("Aadhaar updated successfully.");
        } else {
            System.out.println("Aadhaar not found for this Person.");
        }
    }

    // 7. Delete Person Using Person ID
    @Override
    public void deletePersonOnlyUsingPid() {
        int id = ValidetionUtil.validInt("Enter Person ID: ");

        Person p = PersonDAO.getPersonOnly(id);

        if (p != null) {
            PersonDAO.deletePerson(p);
            System.out.println("Person deleted successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }

    // 8. Delete Aadhaar Using Person ID
    @Override
    public void deleteAdharOnlyUsingPid() {
        int id = ValidetionUtil.validInt("Enter Person ID: ");

        Person p = PersonDAO.getPersonOnly(id);

        if (p == null) {
            System.out.println("Person not found.");
            return;
        }

        if (p.getAdhar() != null) {
            PersonDAO.deleteAdhar(p);
            System.out.println("Aadhaar deleted successfully.");
        } else {
            System.out.println("Aadhaar not found for this Person.");
        }
    }

    // 9. Get Person Using Aadhaar ID
    @Override
    public void getPersonOnlyUsingAid() {
        int id = ValidetionUtil.validInt("Enter Aadhaar ID: ");

        Adhar a = AdharDAO.getPersonInfo(id);

        if (a == null) {
            System.out.println("Aadhaar not found.");
            return;
        }

        if (a.getPerson() != null) {
            a.getPerson().getPersonOnly();
        } else {
            System.out.println("Person not found for this Aadhaar.");
        }
    }

    // 10. Get Aadhaar Using Aadhaar ID
    @Override
    public void getAdharOnlyUsingAid() {
        int id = ValidetionUtil.validInt("Enter Aadhaar ID: ");

        Adhar a = AdharDAO.getPersonInfo(id);

        if (a != null) {
            a.getAdharOnly();
        } else {
            System.out.println("Aadhaar not found.");
        }
    }

    // 11. Update Person Using Aadhaar ID
    @Override
    public void updatePersonDetailsUsingAid() {
        int id = ValidetionUtil.validInt("Enter Aadhaar ID: ");

        Adhar a = AdharDAO.getPersonInfo(id);

        if (a == null) {
            System.out.println("Aadhaar not found.");
            return;
        }

        Person person = a.getPerson();

        if (person != null) {
            person.setpName(
                ValidetionUtil.validString("Enter New Person Name: ")
            );

            PersonDAO.updatePerson(person);
            System.out.println("Person updated successfully.");
        } else {
            System.out.println("Person not found for this Aadhaar.");
        }
    }

    // 12. Update Aadhaar Using Aadhaar ID
    @Override
    public void updateAdharDetailsUsingAid() {
        int id = ValidetionUtil.validInt("Enter Aadhaar ID: ");

        Adhar a = AdharDAO.getPersonInfo(id);

        if (a != null) {
            a.setAdharNo(
                ValidetionUtil.ValidAdhar("Enter New Aadhaar Number: ")
            );

            AdharDAO.updateAdhar(a);
            System.out.println("Aadhaar updated successfully.");
        } else {
            System.out.println("Aadhaar not found.");
        }
    }

    // 13. Delete Person Using Aadhaar ID
    @Override
    public void deletePersonOnlyUsingAid() {
        int id = ValidetionUtil.validInt("Enter Aadhaar ID: ");

        Adhar a = AdharDAO.getPersonInfo(id);

        if (a == null) {
            System.out.println("Aadhaar not found.");
            return;
        }

        if (a.getPerson() != null) {
            PersonDAO.deletePerson(a.getPerson());
            System.out.println("Person deleted successfully.");
        } else {
            System.out.println("Person not found for this Aadhaar.");
        }
    }

    // 14. Delete Aadhaar Using Aadhaar ID
    @Override
    public void deleteAdharOnlyUsingAid() {
        int id = ValidetionUtil.validInt("Enter Aadhaar ID: ");

        Adhar a = AdharDAO.getPersonInfo(id);

        if (a != null) {
            AdharDAO.deleteAdhar(a);
            System.out.println("Aadhaar deleted successfully.");
        } else {
            System.out.println("Aadhaar not found.");
        }
    }
}
