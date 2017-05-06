package org.thoughtworks.training.bookrenting.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Aman Sachan
 * Model for popular books in library
 */
@XmlRootElement
public class PopularBook {
	String book;
	int count;
	
	PopularBook(){}
	
	public PopularBook(String book, int count) {
		super();
		this.book = book;
		this.count = count;
	}
	
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
}
