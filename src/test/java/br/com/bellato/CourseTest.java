package br.com.bellato;

import br.com.bellato.dao.CourseDAO;
import br.com.bellato.dao.ICourseDAO;
import br.com.bellato.domain.Course;
import br.com.bellato.domain.Enrollment;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class CourseTest {

    private ICourseDAO courseDAO;

    public CourseTest() {
        courseDAO = new CourseDAO();
    }

    @Test
    public void register() {
        Course course = new Course();
        course.setCode("A11");
        course.setDescription("COURSE TEST");
        course.setName("Just a test.");
        course = courseDAO.register(course);

        assertNotNull(course);
        assertNotNull(course.getId());
    }

    @Test
    public void search() {
        List<Course> courses = courseDAO.search();
        assertNotNull(courses);
    }

    @Test
    public void remove() {

        Course course = new Course();
        course.setCode("B5");
        course.setDescription("COURSE TEST (REMOVAL)");
        course.setName("Just a test for removing.");
        course = courseDAO.register(course);
        assertNotNull(course);
        assertNotNull(course.getId());

        courseDAO.remove(course);

        List<Course> courses = courseDAO.search();
        for (Course e : courses) {
            assertNotEquals(course.getId(), e.getId());
        }
    }

    @Test
    public void update() {
        Course course = new Course();
        course.setCode("X2");
        course.setDescription("COURSE TEST");
        course.setName("Just a test.");
        course = courseDAO.register(course);
        assertNotNull(course);
        assertNotNull(course.getId());

        course.setName("Updated the course name.");
        course = courseDAO.update(course);

        Assert.assertEquals("Updated the course name.", course.getName());

    }

}
