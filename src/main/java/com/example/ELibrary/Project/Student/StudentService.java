package com.example.ELibrary.Project.Student;
import com.example.ELibrary.Project.Book.Book;

import com.example.ELibrary.Project.Book.BookRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public StudentService(StudentRepository studentRepository, BookRepository bookRepository){
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    public List<Book> getBorrowedBooks(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));

        // Use a custom query to retrieve the borrowed books for the specified student
        return bookRepository.findBorrowedBooksByStudent(student);
    }
    public void borrowBook(Long studentId, Long bookId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist"));

        if (!book.isAvailable()) {
            throw new IllegalStateException("The book is not available for borrowing.");
        }

        // Update book availability and add the book to the student's list of borrowed books
        book.setAvailable(false);
        student.getBorrowedBooks().add(book);

        studentRepository.save(student);
        bookRepository.save(book);
    }

    public void returnBook(Long studentId, Long bookId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book with id " + bookId + " does not exist"));

        if (!student.getBorrowedBooks().contains(book)) {
            throw new IllegalStateException("The student did not borrow this book.");
        }

        // Update book availability and remove the book from the student's list of borrowed books
        book.setAvailable(true);
        student.getBorrowedBooks().remove(book);

        studentRepository.save(student);
        bookRepository.save(book);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException(
                "student with id " + studentId + " does not exist"));
        if (name !=null && name.length()>0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email !=null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            student.setEmail(email);
        }
    }


}
