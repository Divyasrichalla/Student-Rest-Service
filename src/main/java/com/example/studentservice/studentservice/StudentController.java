package com.example.studentservice.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
	@Autowired
	private StudentProps studentProps;
	@Autowired
	private StudentService service;

	@GetMapping("/studentid")
	public int getId(){
		return studentProps.getId();
	}

	@GetMapping("/studentname")
	public String getName(){
		return studentProps.getName();
	}
	@GetMapping("/studentdetails")
	public StudentEntity getStudentDetails(){
		StudentEntity entity = new StudentEntity(studentProps.getId(), studentProps.getName(), studentProps.getMarks(), studentProps.getSection());
		return entity;
	}
	@GetMapping("/listofstudentdetails")
	public List<StudentEntity> getListofStudents(){
		StudentEntity entity = new StudentEntity(studentProps.getId(), studentProps.getName(), studentProps.getMarks(), studentProps.getSection());
		StudentEntity entity1 = new StudentEntity(studentProps.getId(), studentProps.getName(), studentProps.getMarks(), studentProps.getSection());
		List<StudentEntity> list = new ArrayList<>();
		list.add(entity);
		list.add(entity1);
		return list;
	}
	@PostMapping("/saveStdtDetails")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public StudentDto saveStudentDetails(@RequestBody StudentDto studentDto){
		StudentDto studentDto1 = service.saveStudentDetails(studentDto);
		return studentDto1;
	}

	@GetMapping("/getstddetails/{id}")
	public StudentDto retriveStdtDetails(@PathVariable int id){
		StudentDto studentDto = service.retriveStudentDetails(id);
		return studentDto;
	}

	@GetMapping("/retriveAllDetails")
	@ResponseBody
	public List<StudentDto> retriveAllStudentsDetails(){
		List<StudentDto> dtoList = service.retriveAllDetails();
		return dtoList;
	}
	@GetMapping("/getDetailsbyName")
	@ResponseBody
	public StudentDto retriveDetailsByName(@RequestParam(name = "name") String studentName){
		StudentDto studentDto = service.retriveByName(studentName);
		return studentDto;
	}
	@DeleteMapping("/deleteById/{id}")
	@ResponseBody
	public String deleteStudentById(@PathVariable int id){
		service.deleteStudentById(id);
		return "Deleted the record";

	}
}
