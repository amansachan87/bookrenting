package org.thoughtworks.training.bookrenting.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.model.PopularBook;

/**
 * @author Aman Sachan
 * Class for database query support
 *
 */
public class BookRecords {
	
	/**
	 * Function: Provides all the books rented by particular User
	 * @param user
	 * @return list of books
	 */
	public List<BookUser> getBooksRentedByUser(String user){
		ResultSet rs = null;
		List<BookUser> list = new ArrayList<>();
		
		try {
			String query = "select * from library.bookrent where user = " + "'" + user + "'";
			rs = MySqlCon.stmt.executeQuery(query);
			while(rs.next())
				list.add(new BookUser(rs.getString(1), rs.getString(2), rs.getDate(3)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Function: To Assign book to User
	 * @param bookUser
	 * @return BookUser
	 */
	public BookUser assignBook(BookUser bookUser){
		BookUser bookuser = new BookUser();
		ResultSet rs = null;
		String query;
		int count = 0;
		
		try {
			String userName = bookUser.getUser();
			String bookName = bookUser.getBook();
			Date dateIssue = new Date();
			java.sql.Date sqlDate = new java.sql.Date(dateIssue.getTime());
			
			query = "select * from library.bookrent where user = " + "'" + bookUser.getUser() + "'" + " AND " + "book = '" + bookUser.getBook() + "'";
			rs = MySqlCon.stmt.executeQuery(query);
			
			while(rs.next()){
				count++;
			}
			
			if(count != 0){
				return null;
			}
			
			query = "insert into library.bookrent (user, book, dateissue) values ("+"'" + userName + "'"+ "," + "'" + bookName + "'"+ "," + "'" + sqlDate + "'"+ ")";
			MySqlCon.stmt.executeUpdate(query);
			query = "select * from library.bookrent where user = " + "'" + bookUser.getUser() + "'" + "AND " + "book = " + "'" + bookUser.getBook() + "'";
			rs = MySqlCon.stmt.executeQuery(query);
			while(rs.next()){
				bookuser.setBook(rs.getString(1));
				bookuser.setBook(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookUser;
	}
	
	/**
	 * Function: Provides most popular book in library based on rented count
	 * @return List of books
	 */
	public List<PopularBook> getMostPoularBooks(){
		ResultSet rs = null;
		List<PopularBook> list = new ArrayList<>();
		
		try{
			String query = "select book, count(book) as count from library.bookrent GROUP BY book having count(book) > 1";
			rs = MySqlCon.stmt.executeQuery(query);
			while(rs.next()){
				list.add(new PopularBook(rs.getString(1), rs.getInt(2)));	
			}
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
		return list;
	}
	
	/**
	 * Function: Update return date in database
	 * @param bookUser
	 * @return BookUser
	 */
	public BookUser returnBook(BookUser bookUser){
		ResultSet rs = null;
		String user = bookUser.getUser();
		String book = bookUser.getBook();
		String query;
		
		try{
			Date dateReturn = new Date();
			java.sql.Date sqlDate = new java.sql.Date(dateReturn.getTime());
			
			query = "select * from library.bookrent where user = " + "'" + user + "'" + " AND " + "book = '" + book + "'";
			rs = MySqlCon.stmt.executeQuery(query);
			if(rs != null){
				query = "update library.bookrent " + "set datereturn = " + "'" + sqlDate + "'" + " where user = " + "'" + user + "'" + " AND " + "book = '" + book + "'";
				MySqlCon.stmt.executeUpdate(query);
				return bookUser;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Function: Remove book from User
	 * @param bookUser
	 * @return BookUser
	 */
	public BookUser removeBook(BookUser bookUser){
		ResultSet rs = null;
		String user = bookUser.getUser();
		String book = bookUser.getBook();
		String query;
		
		try{
			query = "select * from library.bookrent where user = " + "'" + user + "'" + " AND " + "book = '" + book + "'";
			rs = MySqlCon.stmt.executeQuery(query);
			if(rs != null){
				query = "delete from library.bookrent where user = " + "'" + user + "'" + " AND " + "book = '" + book + "'";
				MySqlCon.stmt.executeUpdate(query);
				return bookUser;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
