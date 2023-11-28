package com.sparta.mnm.libraryproject.model.services;

import com.sparta.mnm.libraryproject.model.enities.AuthorDTO;
import com.sparta.mnm.libraryproject.model.enities.BookDTO;
import com.sparta.mnm.libraryproject.model.repositories.AuthorRepository;
import com.sparta.mnm.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    // Autowired means it will create
    // all the dependencies in order for you
    // to be able to use this.
    // Like a SUPER @bean
    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public ArrayList<AuthorDTO> findAuthorsWithMoreThanOneBook() {
        ArrayList<AuthorDTO> authors = new ArrayList<>();
        ArrayList<BookDTO> books = (ArrayList<BookDTO>) bookRepository.findAll();
        ArrayList<AuthorDTO> temp = new ArrayList<AuthorDTO>();
        for (BookDTO book : books) {
            if (temp.contains(book.getAuthor())) {
                authors.add(book.getAuthor());
            }else {
                temp.add(book.getAuthor());
            }
        }
        return authors;
    }

    public ArrayList<BookDTO> findAutoBiographies() {
        ArrayList<BookDTO> books = (ArrayList<BookDTO>) bookRepository.findAll();
        ArrayList<BookDTO> temp = new ArrayList<BookDTO>();
        for (BookDTO book : books) {
            if (book.getTitle().contains(book.getAuthor().getFullName())) {
                temp.add(book);
            }
        }
        return temp;
     }
}
