package com.xuetaoshi.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.xuetaoshi.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
