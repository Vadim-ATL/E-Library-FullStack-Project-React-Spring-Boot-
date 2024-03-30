package com.example.ELibrary.Project.Student;

import com.example.ELibrary.Project.Book.Book;

import jakarta.persistence.*;

@Entity
@Table
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowedBook() {
    }

    public BorrowedBook(Student student, Book book) {
        this.student = student;
        this.book = book;
    }
}
