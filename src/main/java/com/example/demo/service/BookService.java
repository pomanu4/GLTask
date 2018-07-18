package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IBookDao;
import com.example.demo.entity.BookClass;
import com.example.demo.serviceInterf.IBookService;

@Service
@Transactional
public class BookService implements IBookService {
	
	@Autowired
	private IBookDao bookDao;

	@Override
	public List<BookClass> getAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public BookClass saveBook(BookClass book) {
		bookDao.save(book);
		return book;
	}
	
	

}
