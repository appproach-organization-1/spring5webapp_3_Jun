package ishanguru.springframework.spring5webapp.bootstrap;

import ishanguru.springframework.spring5webapp.domain.Author;
import ishanguru.springframework.spring5webapp.domain.Book;
import ishanguru.springframework.spring5webapp.domain.Publisher;
import ishanguru.springframework.spring5webapp.repositories.AuthorRepository;
import ishanguru.springframework.spring5webapp.repositories.BookRepository;
import ishanguru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Started in Bootstrap");
        Publisher arihant=new Publisher("Arihant","Yahi bagal mai hai ghar","Apna Saharanpur","UP","247001");


        publisherRepository.save(arihant);

        Author arun=new Author("Arun","Sharma");
        Book add=new Book("CAT","12233");
        add.setPublisher(arihant);
        add.getAuthors().add(arun);
        arihant.getBooks().add(add);
        arun.getBooks().add(add);


        authorRepository.save(arun);
        bookRepository.save(add);
        publisherRepository.save(arihant);

        Author linus=new Author("Linus","Torvalds");
        Book git=new Book("Git","442233");
        git.setPublisher(arihant);
        arihant.getBooks().add(git);
        linus.getBooks().add(git);
        git.getAuthors().add(linus);

        authorRepository.save(linus);
        bookRepository.save(git);



        publisherRepository.save(arihant);

        System.out.println("Started in bootstrap");
        System.out.println("No. of publisher"+arihant.getBooks().size());



    }
}
