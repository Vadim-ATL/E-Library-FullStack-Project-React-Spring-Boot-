package com.example.ELibrary.Project.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student("Mariam",LocalDate.of(2000,Month.JANUARY,5),"mariam.jamal@gmail.com","+7 777 777 77 77");
            Student alex = new Student("Alex",LocalDate.of(2004,Month.JANUARY,5),"alex.jamal@gmail.com","+7 747 777 77 77");
        repository.saveAll(List.of(mariam,alex));
        };
    }
}
