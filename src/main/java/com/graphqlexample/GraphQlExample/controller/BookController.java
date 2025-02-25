package com.graphqlexample.GraphQlExample.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqlexample.GraphQlExample.entity.Author;
import com.graphqlexample.GraphQlExample.entity.Book;
import com.graphqlexample.GraphQlExample.repository.AuthorRepository;
import com.graphqlexample.GraphQlExample.repository.BookRepository;

@Controller
public class BookController {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
	public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
	
	@QueryMapping
	public Book bookById(@Argument Long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	@QueryMapping
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	@MutationMapping
	public Book addBook(@Argument String title,
						@Argument Long authorId,
						@Argument Integer pageCount,
						@Argument Integer publishedYear) {
		Author author = authorRepository.findById(authorId)
				.orElseThrow(()->new RuntimeException("Author Not found"));
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPageCount(pageCount);
		book.setPublishedYear(publishedYear);
		
		return bookRepository.save(book);
	}
	
	 @MutationMapping
	    public Book updateBook(@Argument Long id, 
	                          @Argument String title,
	                          @Argument Integer pageCount,
	                          @Argument Integer publishedYear) {
	        Book book = bookRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Book not found"));
	            
	        if (title != null) {
	            book.setTitle(title);
	        }
	        
	        if (pageCount != null) {
	            book.setPageCount(pageCount);
	        }
	        
	        if (publishedYear != null) {
	            book.setPublishedYear(publishedYear);
	        }
	        
	        return bookRepository.save(book);
	    }
	    
	    @MutationMapping
	    public boolean deleteBook(@Argument Long id) {
	        if (bookRepository.existsById(id)) {
	            bookRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}


