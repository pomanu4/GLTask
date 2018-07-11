package com.example.demo.component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.BookClass;
import com.example.demo.serviceInterf.BookServInterf;

@Component
public class ImitateDataBase {
	
	@Autowired
	private BookServInterf bookServ;
	
	private static List<BookClass> books = createBooks();
	
	@PostConstruct
	public void InitDataBase() {
		books.stream().map((book)-> bookServ.saveBook(book)).count();
	}
	
	private static List<BookClass> createBooks() {
		List<BookClass> books = new ArrayList<>();
		BookClass book1 = new BookClass("Hello Kitty", 777);
		BookClass book2 = new BookClass("Pink Rabbits", 22);
		
		books.add(book1);
		books.add(book2);
		
		return books;
	}

}
