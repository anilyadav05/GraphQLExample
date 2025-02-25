package com.graphqlexample.GraphQlExample.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer pageCount;
	private Integer publishedYear;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;

	public Book() {
		super();
	}

	public Book(Long id, String title, Integer pageCount, Integer publishedYear, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.pageCount = pageCount;
		this.publishedYear = publishedYear;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(Integer publishedYear) {
		this.publishedYear = publishedYear;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, pageCount, publishedYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(pageCount, other.pageCount) && Objects.equals(publishedYear, other.publishedYear)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pageCount=" + pageCount + ", publishedYear=" + publishedYear
				+ ", author=" + author + "]";
	}
	
}
