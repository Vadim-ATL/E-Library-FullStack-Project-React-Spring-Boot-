package com.example.ELibrary.Project.Book;

import com.example.ELibrary.Project.Student.Student;
import com.example.ELibrary.Project.Student.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    public List<Book> getBorrowedBooks() {return bookRepository.findBorrowedBooks();}

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByTitle(book.getTitle());

        if(bookOptional.isPresent()){
            throw new IllegalStateException("Title taken");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);

        if (!exists){
            throw new IllegalStateException("Book with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId, String title, String ISBN) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new IllegalStateException(
                        "book with id " + bookId + " does not exist"));
        if (title !=null && title.length()>0 && !Objects.equals(book.getTitle(), title)){
            book.setTitle(title);
        }
        if (ISBN !=null && ISBN.length()>0 && !Objects.equals(book.getISBN(), ISBN)){
            Optional<Book> bookOptional = bookRepository
                    .findBookByTitle(title);
            if(bookOptional.isPresent()){
                throw new IllegalStateException("ISBN is taken");
            }
            book.setISBN(ISBN);
        }
    }


}
