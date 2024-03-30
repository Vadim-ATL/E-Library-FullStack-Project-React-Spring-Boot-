package com.example.ELibrary.Project.Book;

import com.example.ELibrary.Project.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your React app
@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){this.bookService = bookService;}

    @GetMapping
    public List <Book> bookList(){ return bookService.getBooks();}

    @GetMapping(path = "/borrowedBooks")
    public List <Book> borrowedBooks(){ return bookService.getBorrowedBooks();}

    @PostMapping(path="/addNewBook")
    public void registerNewBook(@RequestBody Book book){ bookService.addNewBook(book);}

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){bookService.deleteBook(bookId);}

    @PutMapping(path="{bookId}")
    public void updateBook(
        @PathVariable("{bookId}") Long bookId,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String ISBN){
        bookService.updateBook(bookId,title,ISBN);
    }
}
