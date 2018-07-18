package com.example.demo.serviceInterf;

import java.util.List;

import com.example.demo.entity.BookClass;

public interface IBookService {
	
	List<BookClass> getAllBooks();
	
	BookClass saveBook(BookClass book);

}
