package org.thoughtworks.training.bookrenting.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.service.BookService;

public class BookRentingServiceTest {
	
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
	
	private void addBook(BookUser bookUser){

		BookUser result = bookService.assignBooktoUser(bookUser.getUser(), bookUser.getBook());	
		assertEquals("book1", result.getBook());
		assertEquals("user1", result.getUser());
		bookService.removeBookfromUser(bookUser.getUser(), bookUser.getBook());
	}
	
	private void addBookForNull(BookUser bookUser){

		BookUser result = bookService.assignBooktoUser(bookUser.getUser(), bookUser.getBook());	
		assertEquals(null, result);
	}
	
	@Test
	public void testAddBook() {
		BookUser bookUser = new BookUser();
		bookUser.setUser("user1");
		bookUser.setBook("book1");		
		addBook(bookUser);
		
		bookUser.setUser("user1");
		bookUser.setBook("");
		addBookForNull(bookUser);
		
		bookUser.setUser("");
		bookUser.setBook("book1");
		addBookForNull(bookUser);
		
		bookUser.setUser("");
		bookUser.setBook("");
		addBookForNull(bookUser);
	}
}
