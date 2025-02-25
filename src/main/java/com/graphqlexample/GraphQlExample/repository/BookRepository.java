package com.graphqlexample.GraphQlExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqlexample.GraphQlExample.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
