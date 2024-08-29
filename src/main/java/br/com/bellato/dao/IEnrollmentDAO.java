package br.com.bellato.dao;

import br.com.bellato.domain.Enrollment;

import java.util.List;

public interface IEnrollmentDAO {

    Enrollment register(Enrollment erl);

    List<Enrollment> search();

    Enrollment remove(Enrollment erl);
}
