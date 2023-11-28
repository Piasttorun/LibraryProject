package com.sparta.mnm.libraryproject.model.repositories;

import com.sparta.mnm.libraryproject.model.enities.AuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDTO, Integer> {
}