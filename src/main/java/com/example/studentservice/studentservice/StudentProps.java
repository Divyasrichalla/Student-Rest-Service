package com.example.studentservice.studentservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("student")
@Getter
@Setter
@NoArgsConstructor
@Component
public class StudentProps {

	private int id;
	private String name;
	private String section;
	private int marks;

}
