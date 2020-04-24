package chingachcook.spring.demo.bootstrap;

import chingachcook.spring.demo.domain.Author;
import chingachcook.spring.demo.domain.Book;
import chingachcook.spring.demo.repositories.AuthorRepository;
import chingachcook.spring.demo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author jeffrey = new Author("Jeffrey", "Victor Sutherland");
        Book scrum = new Book("Scrum methodology", "kz12312312335");

        jeffrey.getBooks().add(scrum);
        scrum.getAuthors().add(jeffrey);

        authorRepository.save(jeffrey);
        bookRepository.save(scrum);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "kz123123123599");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
