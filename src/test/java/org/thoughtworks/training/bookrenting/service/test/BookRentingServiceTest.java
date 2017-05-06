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

	@Test
	public void testAddBook() {
		
		BookUser bookUser = new BookUser();
		bookUser.setUser("user1");
		bookUser.setBook("book1");
		assertEquals("book1", bookService.assignBooktoUser("user1", "book1").getBook());
		assertEquals("user1", bookService.assignBooktoUser("user1", "book1").getUser());
	}
}





