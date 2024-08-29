package br.com.bellato.dao;

import br.com.bellato.domain.Course;
import br.com.bellato.domain.Enrollment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CourseDAO implements ICourseDAO {

    private EntityManagerFactory entityManagerFactory;

    public CourseDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("ExampleJPA");
    }

    @Override
    public Course register(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        return course;
    }

    public List<Course> search() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Course> query = entityManager.createQuery("SELECT e FROM Course e", Course.class);
        List<Course> courses = query.getResultList();

        for (Course course : courses) {
            System.out.println("ID: " + course.getId() + ", Course Code: " + course.getCode() +
                    ", Course Name: " + course.getName() +
                    ", Course Description: " + course.getDescription());
        }

        return courses;
    }

    public Course remove(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course_remove = entityManager.find(Course.class, course.getId());
        if (course_remove != null) {
            System.out.println("The following course will be removed from the system.");
            System.out.println("Course ID :: " + course_remove.getId());
            System.out.println("Course Name :: " + course_remove.getName());
            System.out.println("Course Description :: " + course_remove.getDescription());
            entityManager.remove(course_remove);
        }
        entityManager.getTransaction().commit();

        return course;
    }

    public Course update(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Course course_update = entityManager.find(Course.class, course.getId());

        if (course_update != null) {
            course_update.setName(course.getName());
            course_update.setCode(course.getCode());
            course_update.setDescription(course.getDescription());

            System.out.println("The following course will be updated in the system:");
            System.out.println("Course ID :: " + course_update.getId());
            System.out.println("Updated Course Name :: " + course_update.getName());
            System.out.println("Updated Course Description :: " + course_update.getDescription());

        }

        entityManager.getTransaction().commit();


        return course_update;
    }

}
