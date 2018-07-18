package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookClass;
import com.example.demo.serviceInterf.IBookService;

@RestController
public class AppRestController {
	
	@Autowired
	private IBookService bookServ;
	
	@RequestMapping(path= {"books/all"}, method=RequestMethod.GET)
	public ResponseEntity<List<BookClass>> getAllBooks(){
		List<BookClass> allBooks = bookServ.getAllBooks();
		
		return new ResponseEntity<List<BookClass>>(allBooks, HttpStatus.OK);
	}
	
	@RequestMapping(path= {"books/addone"}, method=RequestMethod.POST)
	public ResponseEntity<String> addOneBookToDataBase( @RequestParam("name") String name, @RequestParam("price") int price){		
		BookClass book = new BookClass(name, price);
		bookServ.saveBook(book);
		
		return new ResponseEntity<String>("book sucessfuli added", HttpStatus.OK);
	}
	
	@RequestMapping(path= {"books/object"}, method=RequestMethod.POST)
	public ResponseEntity<String> addBoookAsJsonObject(@RequestBody BookClass book){
		bookServ.saveBook(book);
		return new ResponseEntity<String>("object succesfuly added", HttpStatus.OK);
	}
}
