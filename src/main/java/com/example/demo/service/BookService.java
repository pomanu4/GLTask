package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAOInterf;
import com.example.demo.entity.BookClass;
import com.example.demo.serviceInterf.BookServInterf;

@Service
@Transactional
public class BookService implements BookServInterf {
	
	@Autowired
	private BookDAOInterf bookDao;

	@Override
	public List<BookClass> getAllBook() {
		return bookDao.findAll();
	}

	@Override
	public BookClass saveBook(BookClass book) {
		bookDao.save(book);
		return book;
	}
	
	

}
