package org.thoughtworks.training.bookrenting.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.model.PopularBook;
import org.thoughtworks.training.bookrenting.service.BookService;

/**
 * @author Aman Sachan
 * 
 *
 */

@Path("/rent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
	
	BookService bookService = new BookService();
	
	@GET	
	public List<BookUser> bookRentedByUser(@QueryParam ("user") String userName){
		
		return bookService.getBooksRentedByUser(userName);
	}

	@POST
	public BookUser assignBook(@QueryParam ("user") String userName,
							   @QueryParam ("book") String bookName){
		
		return bookService.assignBooktoUser(userName, bookName);
	}

	@GET
	@Path("/popular")
	public List<PopularBook> popularBook(){
		return bookService.getPopularBooks();
	}
	
	@DELETE
	public BookUser deleteBook(@QueryParam ("user") String userName,
								@QueryParam ("book") String bookName){
		
		BookUser bookUser = new BookUser();
		bookUser.setUser(userName);
		bookUser.setBook(bookName);
		
		return bookService.removeBookfromUser(bookUser);
	}
}
