package org.thoughtworks.training.bookrenting.service.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.service.BookService;

public class BookHoldedByUserTest {
	
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
	
	private void testWithNoBook(List<BookUser> list, String userName){
		List<BookUser> result = bookService.getBooksRentedByUser(userName);
		for(int i = 0; i < list.size(); i++){
			assertEquals(list.get(i).getBook(), result.get(i).getBook());
			assertEquals(list.get(i).getUser(), result.get(i).getUser());
		}
	}
	
	private void testWithMultiPleBook(List<BookUser> list, String userName){
		
		List<BookUser> result = bookService.getBooksRentedByUser(userName);
		
		for(int i = 0; i < list.size(); i++){
			assertEquals(list.get(i).getBook(), result.get(i).getBook());
			assertEquals(list.get(i).getUser(), result.get(i).getUser());
		}
	}

	@Test
	public void holededBook() {
		List<BookUser> list = new ArrayList<>();
		testWithNoBook(list, "user11");
		
		BookUser bookUser1 = new BookUser();
		BookUser bookUser2 = new BookUser();
		bookUser1.setUser("user11");
		bookUser1.setBook("book11");
		bookUser2.setUser("user11");
		bookUser2.setBook("book12");
		bookService.assignBooktoUser(bookUser1.getUser(), bookUser1.getBook());
		bookService.assignBooktoUser(bookUser2.getUser(), bookUser2.getBook());
		list.add(new BookUser("user11", "book11"));
		list.add(new BookUser("user11", "book12"));
		
		testWithMultiPleBook(list, "user11");
		bookService.removeBookfromUser(bookUser1.getUser(), bookUser1.getBook());
		bookService.removeBookfromUser(bookUser2.getUser(), bookUser2.getBook());
	}
}
