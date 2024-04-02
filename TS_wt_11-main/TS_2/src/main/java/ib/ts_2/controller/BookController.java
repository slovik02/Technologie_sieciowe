package ib.ts_2.controller;

import ib.ts_2.entity.Book;
import ib.ts_2.repository.BookRepository;
import ib.ts_2.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookService.create(book);
    }

}

