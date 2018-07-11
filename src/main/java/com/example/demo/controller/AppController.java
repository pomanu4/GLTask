package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BookClass;
import com.example.demo.serviceInterf.BookServInterf;

@Controller
public class AppController {
	
	@Autowired
	private BookServInterf bookServ;
		
	@RequestMapping(path= {"/"}, method=RequestMethod.GET)
	public String indexPage() {
		
		return "index";
	}
	
	@RequestMapping(path= {"/next"}, method=RequestMethod.GET)
	public String nextPage() {
		
		return "next";
	}
	
	@RequestMapping(path= {"add/book"}, method=RequestMethod.GET)
	public String addOneBook(@RequestParam("name") String name, @RequestParam("price") int price){
		BookClass book = new BookClass(name, price);
		bookServ.saveBook(book);
		
		return "redirect:/next";
	}
}
