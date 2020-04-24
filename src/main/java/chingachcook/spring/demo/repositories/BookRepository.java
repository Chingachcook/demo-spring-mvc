package chingachcook.spring.demo.repositories;

import chingachcook.spring.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
