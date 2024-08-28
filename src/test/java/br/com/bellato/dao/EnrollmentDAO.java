package br.com.bellato.dao;

import br.com.bellato.domain.Enrollment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
}
