
package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Adhar;
import com.model.Person;
import com.util.HiabernateUtil;

public class PersonDAO {

    // 1. Add Person
    public static int AddPerson(Person person) {
        SessionFactory sf = HiabernateUtil.getSessionFactory();

        try (Session s = sf.openSession()) {
            Transaction tx = s.beginTransaction();

            try {
                int id = (int) s.save(person);
                tx.commit();

                System.out.println("Person added successfully.");
                return id;

            } catch (RuntimeException e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }

    // 2. Get Person Using Person ID
    public static Person getPersonOnly(int id) {
        SessionFactory sf = HiabernateUtil.getSessionFactory();

        try (Session s = sf.openSession()) {
            return s.get(Person.class, id);
        }
    }

    // 3. Update Person
    public static void updatePerson(Person p) {
        SessionFactory sf = HiabernateUtil.getSessionFactory();

        try (Session s = sf.openSession()) {
            Transaction tx = s.beginTransaction();

            try {
                s.update(p);
                tx.commit();

                System.out.println("Person updated successfully.");

            } catch (RuntimeException e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }

    // 4. Delete Person
    public static void deletePerson(Person p) {
        SessionFactory sf = HiabernateUtil.getSessionFactory();

        try (Session s = sf.openSession()) {
            Transaction tx = s.beginTransaction();

            try {
                Person person = s.get(Person.class, p.getpId());

                if (person == null) {
                    System.out.println("Person not found.");
                    tx.rollback();
                    return;
                }

                // Detach the Aadhaar relationship first
                Adhar adhar = person.getAdhar();
                person.setAdhar(null);

                if (adhar != null) {
                    adhar.setPerson(null);
                }

                s.delete(person);
                tx.commit();

                System.out.println("Person deleted successfully.");

            } catch (RuntimeException e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }

    // 5. Delete Aadhaar Using Person ID
    public static void deleteAdhar(Person p) {
        SessionFactory sf = HiabernateUtil.getSessionFactory();

        try (Session s = sf.openSession()) {
            Transaction tx = s.beginTransaction();

            try {
                Person person = s.get(Person.class, p.getpId());

                if (person == null || person.getAdhar() == null) {
                    System.out.println("Person or Aadhaar not found.");
                    tx.rollback();
                    return;
                }

                Adhar adhar = person.getAdhar();

                // Remove the relationship from both sides
                person.setAdhar(null);
                adhar.setPerson(null);

                // Update owning side before deleting Aadhaar
                s.update(person);
                s.delete(adhar);

                tx.commit();

                System.out.println("Aadhaar deleted successfully.");

            } catch (RuntimeException e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }

    // 6. Get All Persons
    @SuppressWarnings("unchecked")
    public static List<Person> getAll() {
        SessionFactory sf = HiabernateUtil.getSessionFactory();

        try (Session s = sf.openSession()) {
            return s.createQuery("from Person").list();
        }
    }
}
