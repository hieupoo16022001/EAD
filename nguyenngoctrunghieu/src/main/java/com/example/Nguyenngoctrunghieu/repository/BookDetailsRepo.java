package com.example.Nguyenngoctrunghieu.repository;

import com.example.Nguyenngoctrunghieu.entity.BookDetailsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDetailsRepo extends JpaRepository<BookDetailsEntity, Integer> {
    @Query("select p from BookDetailsEntity p where p.name like %:name%")
    List<BookDetailsEntity> findAllByName(String name, Pageable pageable);

    Page<BookDetailsEntity> findAllByNameContaining(String firstname, Pageable pageable);
}
