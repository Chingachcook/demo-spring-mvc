package chingachcook.spring.demo.bootstrap;

import chingachcook.spring.demo.domain.Author;
import chingachcook.spring.demo.domain.Book;
import chingachcook.spring.demo.domain.Publisher;
import chingachcook.spring.demo.repositories.AuthorRepository;
import chingachcook.spring.demo.repositories.BookRepository;
import chingachcook.spring.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author jeffrey = new Author("Jeffrey", "Victor Sutherland");
        Book scrum = new Book("Scrum methodology", "kz12312312335");

        jeffrey.getBooks().add(scrum);
        scrum.getAuthors().add(jeffrey);

        scrum.setPublisher(publisher);
        publisher.getBooks().add(scrum);

        authorRepository.save(jeffrey);
        bookRepository.save(scrum);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "kz123123123599");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
