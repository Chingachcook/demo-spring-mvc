package chingachcook.spring.demo.repositories;

import chingachcook.spring.demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
