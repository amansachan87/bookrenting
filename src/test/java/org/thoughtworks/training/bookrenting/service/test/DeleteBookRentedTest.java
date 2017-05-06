package org.thoughtworks.training.bookrenting.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.service.BookService;

public class DeleteBookRentedTest {
	
	final BookService bookService = new BookService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	void deleteBook(BookUser result, BookUser bookUser){
		bookService.assignBooktoUser(bookUser.getUser(), bookUser.getBook());
		assertEquals(result, bookService.removeBookfromUser(bookUser));
		bookService.removeBookfromUser(bookUser);
	}

	@Test
	public void deleteAddedBook() {
		
		BookUser bookUser = new BookUser();
		bookUser.setUser("user2");
		bookUser.setBook("book2");
		deleteBook(bookUser, bookUser);
		
		bookUser = new BookUser();
		deleteBook(null, bookUser);
	}	
}