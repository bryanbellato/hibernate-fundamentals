package br.com.bellato.dao;

import br.com.bellato.domain.Enrollment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

public class EnrollmentDAO implements IEnrollmentDAO {

    private EntityManagerFactory entityManagerFactory;

    public EnrollmentDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExampleJPA");
    }

    @Override
    public Enrollment register(Enrollment erl) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(erl);
        entityManager.getTransaction().commit();

        return erl;
    }

    public List<Enrollment> search() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Enrollment> query = entityManager.createQuery("SELECT e FROM Enrollment e", Enrollment.class);
        List<Enrollment> enrollments = query.getResultList();

        for (Enrollment enrollment : enrollments) {
            System.out.println("ID: " + enrollment.getId() + ", Code: " + enrollment.getCode() + ", Enrollment Date: " + enrollment.getDateEnrollment() +
                    ", Enrollment Value: " + enrollment.getValue() + ", Enrollment Status: " + enrollment.getStatus());
        }

        return enrollments;
    }

    public Enrollment remove(Enrollment erl) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Enrollment enrollment = entityManager.find(Enrollment.class, erl.getId());
        if (enrollment != null) {
            System.out.println("The following enrollment will be removed from the system.");
            System.out.println("Enrollment ID :: " + enrollment.getId());
            System.out.println("Enrollment Code :: " + enrollment.getCode());
            System.out.println("Enrollment Date :: " + enrollment.getDateEnrollment());
            System.out.println("Enrollment Value :: " + enrollment.getValue());
            System.out.println("Enrollment Status :: " + enrollment.getStatus());
            entityManager.remove(enrollment);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

        return erl;
    }

}
