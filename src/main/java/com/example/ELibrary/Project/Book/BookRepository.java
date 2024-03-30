package com.example.ELibrary.Project.Book;

import com.example.ELibrary.Project.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT s FROM Book s WHERE s.title = ?1")
    Optional<Book> findBookByTitle(String title);

    @Query(value = "SELECT s FROM Book s WHERE s.borrowedByStudents IS NOT EMPTY")
    List<Book> findBorrowedBooks();

    @Query("SELECT b FROM Book b JOIN b.borrowedByStudents s WHERE s = :student")
    List<Book> findBorrowedBooksByStudent(@Param("student") Student student);
}

