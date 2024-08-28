package br.com.bellato;

import br.com.bellato.dao.CourseDAO;
import br.com.bellato.dao.ICourseDAO;
import br.com.bellato.domain.Course;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CourseTest {

    private ICourseDAO courseDAO;

    public CourseTest() {
        courseDAO = new CourseDAO();
    }

    @Test
    public void register() {
        Course course = new Course();
        course.setCode("A1");
        course.setDescription("COURSE TEST");
        course.setName("Just a test.");
        course = courseDAO.register(course);

        assertNotNull(course);
        assertNotNull(course.getId());
    }

}
