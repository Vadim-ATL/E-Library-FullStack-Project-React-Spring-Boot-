package com.example.ELibrary.Project.Student;
import com.example.ELibrary.Project.Book.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> studentList(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @PostMapping(path = "/{studentId}/borrow/{bookId}")
    public void borrowBook(
            @PathVariable("studentId") Long studentId,
            @PathVariable("bookId") Long bookId) {
        studentService.borrowBook(studentId, bookId);
    }

    @PostMapping("/{studentId}/return/{bookId}")
    public void returnBook(
            @PathVariable("studentId") Long studentId,
            @PathVariable("bookId") Long bookId) {
        studentService.returnBook(studentId, bookId);
    }

    @GetMapping("/{studentId}/borrowed-books")
    public List<Book> getBorrowedBooks(@PathVariable("studentId") Long studentId) {
        List<Book> borrowedBooks = studentService.getBorrowedBooks(studentId);
        return borrowedBooks;
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
