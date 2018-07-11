package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookClass;
import com.example.demo.serviceInterf.BookServInterf;

@RestController
public class RestControl {
	
	@Autowired
	private BookServInterf bookServ;
	
	@RequestMapping(path= {"books/all"}, method=RequestMethod.GET)
	public ResponseEntity<List<BookClass>> getAllBooks(){
		List<BookClass> allBooks = bookServ.getAllBook();
		
		return new ResponseEntity<List<BookClass>>(allBooks, HttpStatus.OK);
	}
	
}
