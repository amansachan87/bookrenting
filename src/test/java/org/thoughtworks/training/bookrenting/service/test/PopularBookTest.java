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
import org.thoughtworks.training.bookrenting.model.PopularBook;
import org.thoughtworks.training.bookrenting.service.BookService;

public class PopularBookTest {
	
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
	public void popularBook() {
		
		BookUser bookUser1 = new BookUser();
		BookUser bookUser2 = new BookUser();
		List<PopularBook> list = new ArrayList<>();
		List<PopularBook> result = new ArrayList<>();
		bookUser1.setUser("user11");
		bookUser1.setBook("book11");
		bookUser2.setUser("user12");
		bookUser2.setBook("book11");
		bookService.assignBooktoUser(bookUser1.getUser(), bookUser1.getBook());
		bookService.assignBooktoUser(bookUser2.getUser(), bookUser2.getBook());
		list.add(new PopularBook("book11", 2));
		
		result = bookService.getPopularBooks();
		for(int i = 0; i < list.size(); i++){
			assertEquals(list.get(i).getBook(), result.get(i).getBook());
			assertEquals(list.get(i).getCount(), result.get(i).getCount());
		}
		bookService.removeBookfromUser(bookUser1.getUser(), bookUser1.getBook());
		bookService.removeBookfromUser(bookUser2.getUser(), bookUser2.getBook());
	}
}
