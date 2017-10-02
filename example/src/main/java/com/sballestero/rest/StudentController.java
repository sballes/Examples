package com.sballestero.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sballestero.model.Student;
import com.sballestero.repository.StudentRepository;

@RestController
public class StudentController {

	public static final String API_V1 = "/rest/api/1";
	private static final String STUDENTS = API_V1 + "/students";
	private static final String STUDENT = STUDENTS + "/{id}";
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value = STUDENTS, method = RequestMethod.GET)
	public Iterable<Student> getStudents(){
		LOG.trace("---- inicio peticion getStudents ----");
		Iterable<Student> students = studentRepository.findAll();
		LOG.trace("---- fin peticion getStudents ----");
		return students;
	}
	
	@RequestMapping(value = STUDENT, method = RequestMethod.GET)
	public Student getStudent(final @PathVariable Long id){
		LOG.trace("---- inicio peticion getStudent " + id + " ----");
		Student found = studentRepository.findOne(id);
		LOG.trace("---- fin peticion getStudent " + id + " ----");
		return found;
	}
}
