package com.example.studentservice.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	@Autowired
 	private StudentRepo studentRepo;
	@Autowired
	private StudentProps props;


	public StudentDto saveStudentDetails(StudentDto dto){
		StudentEntity entity = new StudentEntity(dto.getId(), dto.getName(), dto.getMarks(),null);
		StudentEntity save = studentRepo.save(entity);
		StudentDto studentDto = getStudentDto(save);
		return studentDto;
	}

	public StudentDto retriveStudentDetails(int id){
		Optional<StudentEntity> optional = studentRepo.findById(id);
		StudentDto dto = null;
		if(optional.isPresent()){
			StudentEntity studentEntity = optional.get();
			dto = getStudentDto(studentEntity);
			return dto;
		}
		return dto;
	}

	private StudentDto getStudentDto(StudentEntity studentEntity) {
		StudentDto dto = new StudentDto();
		dto.setId(studentEntity.getRollNo());
		dto.setName(studentEntity.getName());
		dto.setMarks(studentEntity.getMarks());
		return dto;
	}

	public List<StudentDto> retriveAllDetails(){
		List<StudentDto> dtoList = new ArrayList<>();
		List<StudentEntity> list = studentRepo.findAll();
		for(StudentEntity entity:list){
			dtoList.add(getStudentDto(entity));
		}
		return dtoList;
	}

	public StudentDto retriveByName(String name){
		StudentEntity entity = studentRepo.findByNameIgnoreCase(name);
		return getStudentDto(entity);
	}

	public void deleteStudentById(int id){
		studentRepo.deleteById(id);
	}
}
