package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BookClass;

public interface BookDAOInterf extends JpaRepository<BookClass, Integer>{
	
	
}
