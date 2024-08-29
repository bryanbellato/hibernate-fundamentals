package br.com.bellato;

import java.time.Instant;
import java.util.List;

import br.com.bellato.dao.EnrollmentDAO;
import br.com.bellato.dao.IEnrollmentDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.bellato.domain.Enrollment;

import static org.junit.Assert.assertNotNull;

public class EnrollmentTest {

    private IEnrollmentDAO enrollmentDAO;

    public EnrollmentTest() {
        enrollmentDAO = new EnrollmentDAO();
    }

    @Test
    public void register() {
        Enrollment erl = new Enrollment();
        erl.setCode("A4");
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

}
