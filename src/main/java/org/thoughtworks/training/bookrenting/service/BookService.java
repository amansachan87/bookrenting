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
		
		return bookRecords.getBooksRentedByUser(user);
	}
	
	public BookUser assignBooktoUser(String user, String book){
		BookUser bookUser = new BookUser();
		bookUser.setUser(user);	
		bookUser.setBook(book);		
		
		return bookRecords.assignBook(bookUser);
	}
	
	public List<PopularBook> getPopularBooks(){
		return bookRecords.getMostPoularBooks();
	}
	
	public BookUser removeBookfromUser(BookUser bookUser){
		
		return bookRecords.removeBook(bookUser);
	}
}
