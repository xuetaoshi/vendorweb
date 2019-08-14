package com.xuetaoshi.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xuetaoshi.student.dal.entities.Student;
import com.xuetaoshi.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository StudentRepository;
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("Sam");
		student.setCourse("Java Web Service");
		student.setFee(30d);
		StudentRepository.save(student);
	}
	
	@Test
	public void testFindStudentById() {
		Optional<Student> findById = StudentRepository.findById(1l);
		System.out.println(findById);
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = StudentRepository.findById(1l).get();
		student.setFee(40d);
		StudentRepository.save(student);
	}
	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		student.setId(1l);
		StudentRepository.delete(student);
	}
}
