package org.thoughtworks.training.bookrenting.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Aman Sachan
 * Model for book user
 */

@XmlRootElement
public class BookUser {
	String user;
	String book;
	Date issueDate;
	Date returnDate;
	
	public BookUser(){}
	
	public BookUser(String user, String book) {
		super();
		this.user = user;
		this.book = book;
		this.issueDate = null;
		this.returnDate = null;
	}	
	
	public BookUser(String user, String book, Date issueDate) {
		super();
		this.user = user;
		this.book = book;
		this.issueDate = issueDate;
		this.returnDate = null;
	}	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}	

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book= book;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}	
}
