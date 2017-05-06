package org.thoughtworks.training.bookrenting.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.service.BookService;

public class BookReturnedTest {
	
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
	
	private void bookReturned(BookUser bookUser){

		bookService.assignBooktoUser(bookUser.getUser(), bookUser.getBook());				
		BookUser result = bookService.returnBookfromUser(bookUser);
		assertEquals(result.getBook(), bookUser.getBook());
		assertEquals(result.getUser(), bookUser.getUser());

		bookService.removeBookfromUser(bookUser);
	}
	
	private void bookReturnedNull(BookUser bookUser){

		bookService.assignBooktoUser(bookUser.getUser(), bookUser.getBook());				
		BookUser result = bookService.returnBookfromUser(bookUser);
		assertEquals(null, result);
	}

	@Test
	public void returnedBook() {
		BookUser bookUser = new BookUser();
		bookUser.setUser("user20");
		bookUser.setBook("book20");
		bookReturned(bookUser);
		
		bookUser.setUser("user20");
		bookUser.setBook(null);
		bookReturnedNull(bookUser);
		
		bookUser.setUser(null);
		bookUser.setBook("book20");
		bookReturnedNull(bookUser);
		
		bookUser.setUser(null);
		bookUser.setBook(null);
		bookReturnedNull(bookUser);
	}
}

