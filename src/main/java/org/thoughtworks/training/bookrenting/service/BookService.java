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
	public List<BookUser> getBooksRentedByUser(String userName){
		
		if(!userName.equals(""))
			return bookRecords.getBooksRentedByUser(userName);
		
		return null;
	}
	
	/**
	 * Function: To assign record of book
	 * @param user
	 * @param book
	 * @return BookUser
	 */
	public BookUser assignBooktoUser(String userName, String bookName){
		BookUser bookUser = new BookUser();
		bookUser.setUser(userName);	
		bookUser.setBook(bookName);	
		
		if(!userName.equals("") && !bookName.equals(""))		
			return bookRecords.assignBook(bookUser);
		
		return null;
	}
	
	/**
	 * Function: To check records for popular books
	 * @return List of books
	 */
	public List<PopularBook> getPopularBooks(int num){
		if(num > 0)
			return bookRecords.getMostPoularBooks(num);
		
		return null;
	}
	
	/**
	 * Function: To update record for returned book
	 * @param bookUser
	 * @return BookUser
	 */
	public BookUser returnBookfromUser(String userName, String bookName){
		BookUser bookUser = new BookUser();
		bookUser.setUser(userName);
		bookUser.setBook(bookName);
		
		if(!userName.equals("") && !bookName.equals(""))
			return bookRecords.returnBook(bookUser);
		
		return null;
	}
	
	/**
	 * Function: To remove record of book rented
	 * @param bookUser
	 * @return BookUser
	 */
	public BookUser removeBookfromUser(String userName, String bookName){
		BookUser bookUser = new BookUser();
		bookUser.setUser(userName);
		bookUser.setBook(bookName);
		
		if(!userName.equals("") && !bookName.equals(""))
			return bookRecords.removeBook(bookUser);
		
		return null;
	}
}
