package com.example.Nguyenngoctrunghieu.service;

import com.example.Nguyenngoctrunghieu.entity.BookDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookDetailsService {
    List<BookDetailsEntity> getAll();
    BookDetailsEntity createBook(BookDetailsEntity p);

    Page<BookDetailsEntity> findAll(Pageable pageable);
    Page<BookDetailsEntity> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
