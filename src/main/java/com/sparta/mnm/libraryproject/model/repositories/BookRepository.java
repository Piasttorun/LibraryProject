package com.sparta.mnm.libraryproject.model.repositories;

import com.sparta.mnm.libraryproject.model.enities.AuthorDTO;
import com.sparta.mnm.libraryproject.model.enities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Integer> {
}