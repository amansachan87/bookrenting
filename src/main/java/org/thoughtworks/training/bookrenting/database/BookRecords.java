package org.thoughtworks.training.bookrenting.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.thoughtworks.training.bookrenting.model.BookUser;
import org.thoughtworks.training.bookrenting.model.PopularBook;

public class BookRecords {
	
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
	
	public BookUser assignBook(BookUser bookUser){
		
		try {
			String userName = bookUser.getUser();
			String bookName = bookUser.getBook();
			Date dateIssue = new Date();
			java.sql.Date sqlDate = new java.sql.Date(dateIssue.getTime());
			String query = "insert into library.bookrent (user, book, dateissue) values ("+"'" + userName + "'"+ "," + "'" + bookName + "'"+ "," + "'" + sqlDate + "'"+ ")";
			MySqlCon.stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookUser;
	}
	
	public List<PopularBook> getMostPoularBooks(){
		ResultSet rs = null;
		List<PopularBook> list = new ArrayList<>();
		
		try{
			String query = "select book, count(book) as count from library.bookrent GROUP BY book having count(book) > 1";
			rs = MySqlCon.stmt.executeQuery(query);
			while(rs.next()){
				list.add(new PopularBook(rs.getString(1), rs.getInt(2)));	
				System.out.println(rs.getString(1) + rs.getInt(2));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
		return list;
	}
	
	public BookUser removeBook(BookUser bookUser){
		ResultSet rs = null;
		BookUser bUser = null;
		String user = bookUser.getUser();
		String book = bookUser.getBook();
		
		try{
			String query = "select * from library.bookrent where user = " + "'" + user + "'" + " AND " + "book = '" + book + "'";
			rs = MySqlCon.stmt.executeQuery(query);
			while(rs.next())
				bUser = new BookUser(rs.getString(1), rs.getString(2), rs.getDate(3));
			query = "delete from library.bookrent where user = " + "'" + user + "'" + " AND " + "book = '" + book + "'";
			MySqlCon.stmt.executeUpdate(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return bUser;
	}
}
