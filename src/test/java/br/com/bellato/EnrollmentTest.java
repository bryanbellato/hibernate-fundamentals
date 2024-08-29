package br.com.bellato;

import java.time.Instant;
import java.util.List;

import br.com.bellato.dao.EnrollmentDAO;
import br.com.bellato.dao.IEnrollmentDAO;
import br.com.bellato.domain.Course;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.bellato.domain.Enrollment;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class EnrollmentTest {

    private IEnrollmentDAO enrollmentDAO;

    public EnrollmentTest() {
        enrollmentDAO = new EnrollmentDAO();
    }

    @Test
    public void register() {
        Enrollment erl = new Enrollment();
        erl.setCode("A71");
        erl.setDateEnrollment(Instant.now());
        erl.setStatus("ACTIVE");
        erl.setValue(2000d);
        erl = enrollmentDAO.register(erl);
        assertNotNull(erl);
        assertNotNull(erl.getId());
    }

    @Test
    public void search() {
        List<Enrollment> enrollments = enrollmentDAO.search();
        assertNotNull(enrollments);
    }

    @Test
    public void remove() {

        Enrollment erl = new Enrollment();
        erl.setCode("F62");
        erl.setDateEnrollment(Instant.now());
        erl.setStatus("ACTIVE");
        erl.setValue(3000d);
        erl = enrollmentDAO.register(erl);
        assertNotNull(erl);
        assertNotNull(erl.getId());

        enrollmentDAO.remove(erl);

        List<Enrollment> enrollments = enrollmentDAO.search();
        for (Enrollment e : enrollments) {
            assertNotEquals(erl.getId(), e.getId());
        }

    }

    @Test
    public void update() {
        Enrollment erl = new Enrollment();
        erl.setCode("X44");
        erl.setDateEnrollment(Instant.now());
        erl.setStatus("ACTIVE");
        erl.setValue(9999d);
        erl = enrollmentDAO.register(erl);
        assertNotNull(erl);
        assertNotNull(erl.getId());

        erl.setStatus("UNACTIVE");
        erl = enrollmentDAO.update(erl);

        Assert.assertEquals("UNACTIVE", erl.getStatus());

    }

}
