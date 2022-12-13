package com.repository;

import com.domain.Student;

public interface StudentRepository extends Repository {
    public Student search(String keyword);
    public void add(Student student);
    public void update(Student student);
    public void delete(String studentNumber);
}
