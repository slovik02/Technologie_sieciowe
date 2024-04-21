package ib.ts_2.services;

import ib.ts_2.entity.Auth;
import ib.ts_2.entity.Book;
import ib.ts_2.entity.User;
import ib.ts_2.repository.BookRepository;
import ib.ts_2.services.error.BookNotExistsException;
import ib.ts_2.services.error.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    /*
      Service class for managing books.
     */
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        /*
          Retrieves all books.
          @return List of all books.
         */
        return (List<Book>) bookRepository.findAll();
    }

    public Book getOne(long id){
        /*
          Retrieves a book by its ID.
          @param id The ID of the book.
         * @return The book with the specified ID.
         * @throws RuntimeException if the book is not found.
         */
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    public Book getByTitle(String title) {
        /*
          Retrieves a book by its title.
          @param title The title of the book.
         * @return The book with the specified title.
         * @throws BookNotExistsException if the book with the given title does not exist.
         */
        return bookRepository.findByTitle(title)
                .orElseThrow(() -> BookNotExistsException.create(title));
    }


    public Book create(Book book){
        /*
          Creates a new book.
          @param book The book to create.
         * @return The created book.
         */
        return bookRepository.save(book);
    }

    public User deleteBook(long id) {
        /*
          Deletes a book by its ID.
          @param id The ID of the book to delete.
         * @return null.
         */
        bookRepository.deleteById(id);
        return null;
    }

    public Book updateBook(Book newBook, long id) {
        /*
          Updates an existing book.
          @param newBook The updated book details.
         * @param id The ID of the book to update.
         * @return The updated book.
         * @throws RuntimeException if the book is not found.
         */
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setAvailableCopies(newBook.getAvailableCopies());

        return bookRepository.save(existingBook);
    }
}

