package org.thoughtworks.training.bookrenting.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.model.PopularBook;
import org.thoughtworks.training.bookrenting.service.BookService;

/**
 * @author Aman Sachan
 * Starting point Rest Calls
 *
 */

@Path("/rent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
	
	BookService bookService = new BookService();
	
	/**
	 * Function: To call rented book service
	 * @param userName
	 * @return List of books
	 */
	@GET	
	public List<BookUser> bookRentedByUser(@QueryParam ("user") String userName){
		
		return bookService.getBooksRentedByUser(userName);
	}

	/**
	 * Function: To call assign book service
	 * @param userName
	 * @param bookName
	 * @return
	 */
	@POST
	public BookUser assignBook(@QueryParam ("user") String userName,
							   @QueryParam ("book") String bookName){
		
		return bookService.assignBooktoUser(userName, bookName);
	}

	/**
	 * Function: To call popular book service
	 * @return List of popular books
	 */
	@GET
	@Path("/popular")
	public List<PopularBook> popularBook(){
		return bookService.getPopularBooks();
	}
	
	/**
	 * Function: To call return book service
	 * @param userName
	 * @param bookName
	 * @return BookUser
	 */
	@PUT
	public BookUser returnBook(@QueryParam ("user") String userName,
								@QueryParam ("book") String bookName){
		
		BookUser bookUser = new BookUser();
		bookUser.setUser(userName);
		bookUser.setBook(bookName);
		
		return bookService.returnBookfromUser(bookUser);
	}
	
	/**
	 * Function: To call remove book service
	 * @param userName
	 * @param bookName
	 * @return BookUser
	 */
	@DELETE
	public BookUser removeBook(@QueryParam ("user") String userName,
								@QueryParam ("book") String bookName){
		
		BookUser bookUser = new BookUser();
		bookUser.setUser(userName);
		bookUser.setBook(bookName);
		
		return bookService.removeBookfromUser(bookUser);
	}
}
