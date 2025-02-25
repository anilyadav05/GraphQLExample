package com.graphqlexample.GraphQlExample.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphqlexample.GraphQlExample.entity.Author;
import com.graphqlexample.GraphQlExample.entity.Book;
import com.graphqlexample.GraphQlExample.repository.AuthorRepository;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;
    
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    @QueryMapping
    public Author authorById(@Argument Long id) {
        return authorRepository.findById(id).orElse(null);
    }
    
    @QueryMapping
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }
    
    @SchemaMapping(typeName = "Author", field = "books")
    public List<Book> books(Author author) {
        return author.getBooks();
    }
    
    @MutationMapping
    public Author addAuthor(@Argument String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

}

