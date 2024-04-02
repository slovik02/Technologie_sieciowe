package ib.ts_2.services;

import ib.ts_2.entity.Book;
import ib.ts_2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // find me all books
    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }

    // get me one book by id
    public Book getOne(long id){
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    // i give u new book and u save it in repository
    public Book create(Book book){
        return bookRepository.save(book);
    }
}

