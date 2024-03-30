package com.example.ELibrary.Project.Book;
import com.example.ELibrary.Project.Student.Student;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long bookId;
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    @ManyToMany(mappedBy = "borrowedBooks")
    private Set<Student> borrowedByStudents = new HashSet<>();

    public Book(){

    }

    public Book(Long bookId, String title, String author, String ISBN, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    public Book(String title, String author, String ISBN, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Set<Student> getBorrowedByStudents() {
        return borrowedByStudents;
    }

    public void addBorrowingStudent(Student student) {
        borrowedByStudents.add(student);
        student.getBorrowedBooks().add(this);
    }

    public void removeBorrowingStudent(Student student) {
        borrowedByStudents.remove(student);
        student.getBorrowedBooks().remove(this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
