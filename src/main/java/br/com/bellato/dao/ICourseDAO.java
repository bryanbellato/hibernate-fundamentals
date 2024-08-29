package br.com.bellato.dao;

import br.com.bellato.domain.Course;
import br.com.bellato.domain.Enrollment;

import java.util.List;

public interface ICourseDAO {

    public Course register(Course course);
    List<Course> search();
    Course remove(Course course);
}
