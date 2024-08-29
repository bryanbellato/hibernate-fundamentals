package br.com.bellato.dao;

import br.com.bellato.domain.Course;

import java.util.List;

public interface ICourseDAO {

    public Course register(Course course);
    List<Course> search();
}
