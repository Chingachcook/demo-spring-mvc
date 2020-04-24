package chingachcook.spring.demo.repositories;

import chingachcook.spring.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
