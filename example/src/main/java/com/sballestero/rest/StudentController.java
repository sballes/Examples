package com.sballestero.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sballestero.model.Student;

@RestController
public class StudentController {

	public static final String API_V1 = "/rest/api/1";
	private static final String STUDENTS = API_V1 + "/students";
	private static final String STUDENT = STUDENTS + "/{id}";
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	
	@RequestMapping(value = STUDENTS, method = RequestMethod.GET)
	public List<Student> getStudents(){
		LOG.trace("---- inicio peticion getStudents ----");
		List<Student> students = getRandomStudents();
		LOG.trace("---- fin peticion getStudents ----");
		return students;
	}
	
	@RequestMapping(value = STUDENT, method = RequestMethod.GET)
	public Student getStudent(final @PathVariable String id){
		LOG.trace("---- inicio peticion getStudent " + id + " ----");
		Student found = null;
		List<Student> students = getRandomStudents();
		for (Student student : students) {
			if (id.equals(student.getId())){
				found = student;
			}
		}
		LOG.trace("---- fin peticion getStudent " + id + " ----");
		return found;
	}
	
	private List<Student> getRandomStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("1", "Juan", "Garcia", "jgarcia@empresa.com"));
		students.add(new Student("2", "Ramón", "Abos", "rabos@empresa.com"));
		students.add(new Student("3", "Teresa", "Etas", "tetas@empresa.com"));
		return students;
	}
}
