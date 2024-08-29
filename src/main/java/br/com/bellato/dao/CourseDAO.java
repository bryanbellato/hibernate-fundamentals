package br.com.bellato.dao;

import br.com.bellato.domain.Course;
import br.com.bellato.domain.Enrollment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CourseDAO implements ICourseDAO {

    @Override
    public Course register(Course course) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return course;
    }

    public List<Course> search() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExampleJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Course> query = entityManager.createQuery("SELECT e FROM Course e", Course.class);
        List<Course> courses = query.getResultList();

        for (Course course : courses) {
            System.out.println("ID: " + course.getId() +
                    ", Course Name: " + course.getName() +
                    ", Course Description: " + course.getDescription());
        }

        entityManager.close();
        entityManagerFactory.close();

        return courses;
    }

}
