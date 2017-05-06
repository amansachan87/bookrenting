package org.thoughtworks.training.bookrenting.service;

import java.util.List;

import org.thoughtworks.training.bookrenting.database.BookRecords;
import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.model.PopularBook;

/**
 * @author Aman Sachan
 * 
 *
 */
public class BookService {
	
	BookRecords bookRecords = new BookRecords();

	public List<BookUser> getBooksRentedByUser(String user){
		
		if(user != null)
			return bookRecords.getBooksRentedByUser(user);
		
		return null;
	}
	
	public BookUser assignBooktoUser(String user, String book){
		BookUser bookUser = new BookUser();
		bookUser.setUser(user);	
		bookUser.setBook(book);	
		
		if(user != null || book != null)		
			return bookRecords.assignBook(bookUser);
		
		return null;
	}
	
	public List<PopularBook> getPopularBooks(){
		return bookRecords.getMostPoularBooks();
	}
	
	public BookUser returnBookfromUser(BookUser bookUser){
		if(bookUser.getUser() != null || bookUser.getBook() != null)
			return bookRecords.returnBook(bookUser);
		
		return null;
	}
	
	public BookUser removeBookfromUser(BookUser bookUser){
		if(bookUser.getUser() != null || bookUser.getBook() != null)
			return bookRecords.removeBook(bookUser);
		
		return null;
	}
}
