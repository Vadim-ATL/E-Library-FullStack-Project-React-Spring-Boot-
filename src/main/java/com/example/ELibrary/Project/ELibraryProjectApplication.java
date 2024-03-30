package com.example.ELibrary.Project;

import com.example.ELibrary.Project.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ELibraryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELibraryProjectApplication.class, args);
	}

}
