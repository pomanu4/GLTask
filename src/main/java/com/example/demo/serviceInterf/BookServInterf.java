package com.example.demo.serviceInterf;

import java.util.List;

import com.example.demo.entity.BookClass;

public interface BookServInterf {
	
	List<BookClass> getAllBook();
	
	BookClass saveBook(BookClass book);

}
