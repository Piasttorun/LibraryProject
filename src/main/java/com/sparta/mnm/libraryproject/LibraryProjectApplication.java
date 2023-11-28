package com.sparta.mnm.libraryproject;

import com.sparta.mnm.libraryproject.model.enities.AuthorDTO;
import com.sparta.mnm.libraryproject.model.enities.BookDTO;
import com.sparta.mnm.libraryproject.model.repositories.AuthorRepository;
import com.sparta.mnm.libraryproject.model.repositories.BookRepository;
import com.sparta.mnm.libraryproject.model.services.LibraryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class LibraryProjectApplication {

    private Logger logger = Logger.getLogger(LibraryProjectApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(LibraryProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {

//            AuthorDTO tayami = new AuthorDTO();
//            tayami.setFullName("Tayami Rai");
//            BookDTO tayamiBook = new BookDTO();
//            tayamiBook.setTitle("300");
//            tayamiBook.setAuthor(tayami);
//            authorRepository.save(tayami);
//            bookRepository.save(tayamiBook);
//            logger.log(Level.INFO,authorRepository.findAll().toString());
//            logger.log(Level.INFO,authorRepository.findById(1).toString());
//            logger.log(Level.INFO,bookRepository.findById(1).toString());
            LibraryService libraryService = new LibraryService(authorRepository,bookRepository);
            logger.log(Level.INFO, libraryService.findAuthorsWithMoreThanOneBook().toString());
            logger.log(Level.INFO, libraryService.findAutoBiographies().toString());
        };
    }
}