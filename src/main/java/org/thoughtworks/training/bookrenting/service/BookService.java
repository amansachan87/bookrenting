package org.thoughtworks.training.bookrenting.service;

import java.util.List;

import org.thoughtworks.training.bookrenting.database.BookRecords;
import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.model.PopularBook;

/**
 * @author Aman Sachan
 * Class: Provides multiple service as assign, popular books, return, remove, books rented
 *
 */
public class BookService {
	
	BookRecords bookRecords = new BookRecords();

	/**
	 * Function: To check records of books rented
	 * @param user
	 * @return
	 */
	public List<BookUser> getBooksRentedByUser(String user){
		
		if(user != null)
			return bookRecords.getBooksRentedByUser(user);
		
		return null;
	}
	
	/**
	 * Function: To assign record of book
	 * @param user
	 * @param book
	 * @return BookUser
	 */
	public BookUser assignBooktoUser(String user, String book){
		BookUser bookUser = new BookUser();
		bookUser.setUser(user);	
		bookUser.setBook(book);	
		
		if(user != null && book != null)		
			return bookRecords.assignBook(bookUser);
		
		return null;
	}
	
	/**
	 * Function: To check records for popular books
	 * @return List of books
	 */
	public List<PopularBook> getPopularBooks(){
		return bookRecords.getMostPoularBooks();
	}
	
	/**
	 * Function: To update record for returned book
	 * @param bookUser
	 * @return BookUser
	 */
	public BookUser returnBookfromUser(BookUser bookUser){
		if(bookUser.getUser() != null && bookUser.getBook() != null)
			return bookRecords.returnBook(bookUser);
		
		return null;
	}
	
	/**
	 * Function: To remove record of book rented
	 * @param bookUser
	 * @return BookUser
	 */
	public BookUser removeBookfromUser(BookUser bookUser){
		if(bookUser.getUser() != null && bookUser.getBook() != null)
			return bookRecords.removeBook(bookUser);
		
		return null;
	}
}
