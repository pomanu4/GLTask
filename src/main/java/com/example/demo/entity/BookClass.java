package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class BookClass implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private int bId;
	
	@Column(name="b_name")
	private String bookName;
	
	@Column(name="price")
	private int bookPrice;
	

	public BookClass() {
		super();
	}

	public BookClass(String bookName, int bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "BookClass [bId=" + bId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}
}
