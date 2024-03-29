package com.repository;

import com.domain.StudentResult;

import java.util.ArrayList;

public interface StudentResultRepository extends Repository {
    public ArrayList<StudentResult> search(String keyword);
    public void add(StudentResult csvClass);
    public void update(StudentResult csvClass);
    public void delete(String studentNumber,String code);
}
