
package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Adhar;
import com.util.HiabernateUtil;

public class AdharDAO {

    private static SessionFactory sf =
            HiabernateUtil.getSessionFactory();

    // 1. Get Aadhaar Using Aadhaar ID
    public static Adhar getPersonInfo(int id) {

        try (Session s = sf.openSession()) {
            return s.get(Adhar.class, id);
        }
    }

    // 2. Update Aadhaar
    public static void updateAdhar(Adhar a) {

        try (Session s = sf.openSession()) {
            Transaction tx = s.beginTransaction();

            try {
                s.update(a);
                tx.commit();

                System.out.println("Aadhaar updated successfully.");

            } catch (RuntimeException e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }

    // 3. Delete Aadhaar
    public static void deleteAdhar(Adhar a) {

        try (Session s = sf.openSession()) {
            Transaction tx = s.beginTransaction();

            try {
                Adhar adhar = s.get(Adhar.class, a.getaId());

                if (adhar == null) {
                    System.out.println("Aadhaar not found.");
                    tx.rollback();
                    return;
                }

                // Remove the relationship before deletion
                if (adhar.getPerson() != null) {
                    adhar.getPerson().setAdhar(null);
                    adhar.setPerson(null);
                }

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
}
		