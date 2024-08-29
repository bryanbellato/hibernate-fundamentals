package br.com.bellato.dao;

import br.com.bellato.domain.Enrollment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EnrollmentDAO implements IEnrollmentDAO {

    @Override
    public Enrollment register(Enrollment erl) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(erl);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return erl;
    }

    public List<Enrollment> search() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Enrollment> query = entityManager.createQuery("SELECT e FROM Enrollment e", Enrollment.class);
        List<Enrollment> enrollments = query.getResultList();

        for (Enrollment enrollment : enrollments) {
            System.out.println("ID: " + enrollment.getId() +
                    ", Enrollment Date: " + enrollment.getDateEnrollment() +
                    ", Enrollment Status: " + enrollment.getStatus());
        }

        entityManager.close();
        entityManagerFactory.close();

        return enrollments;
    }
}
