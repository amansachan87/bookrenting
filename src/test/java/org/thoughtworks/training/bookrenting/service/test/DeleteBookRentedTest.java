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
	
	void deleteBook(BookUser bookUser){
		bookService.assignBooktoUser(bookUser.getUser(), bookUser.getBook());
		BookUser result = bookService.removeBookfromUser(bookUser);
		assertEquals("user2", result.getUser());
		assertEquals("book2", result.getBook());
		bookService.removeBookfromUser(bookUser);
	}
	
	void deleteBookNull(BookUser bookUser){
		bookService.assignBooktoUser(bookUser.getUser(), bookUser.getBook());
		BookUser result = bookService.removeBookfromUser(bookUser);
		assertEquals(null, result);
	}

	@Test
	public void deleteAddedBook() {
		
		BookUser bookUser = new BookUser();
		bookUser.setUser("user2");
		bookUser.setBook("book2");
		deleteBook(bookUser);
		
		bookUser.setUser("user2");
		bookUser.setBook(null);
		deleteBookNull(bookUser);
		
		bookUser.setUser(null);
		bookUser.setBook("book2");
		deleteBookNull(bookUser);
		
		bookUser.setUser(null);
		bookUser.setBook(null);
		deleteBookNull(bookUser);
		
	}	
}