package com.example.ELibrary.Project.Book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner bookCommandLineRunner(BookRepository repository){
        return args -> {
            Book murakami_1 = new Book("Norwegian Wood","Haruki Murakami","9780375704024", true);
            Book murakami_2 = new Book("The Wind-Up Bird Chronicle","Haruki Murakami","978-0679775430", true);
            repository.saveAll(List.of(murakami_1,murakami_2));
        };
    }
}
