package ib.ts_2.repository;

import ib.ts_2.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    Optional<Book> findByTitle(String title);
}
