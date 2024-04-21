package ib.ts_2.controller;

import ib.ts_2.entity.Book;
import ib.ts_2.entity.User;
import ib.ts_2.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")  // searching the book starts with book and then other things
public class BookController{

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable long id){
        return bookService.getOne(id);
    }

    @GetMapping("/getByTitle/{title}")
    public Book getByTitle(@PathVariable String title){
        return bookService.getByTitle(title);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookService.create(book);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public User deleteBook(@PathVariable long id){return bookService.deleteBook(id);}

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("update/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book bookUpdates) {
        return bookService.updateBook(bookUpdates, id);
    }

}

