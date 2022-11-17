package com.groupfour.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.groupfour.entity.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public Collection<Book> getAllBooks() {
		
		Connection connection = null;
		PreparedStatement preparedStatement;

		Collection<Book> bookList = new ArrayList<Book>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wiley", "root", "your_password");

			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("BOOK_ID");
				String bookName = resultSet.getString("BOOK_NAME");
				String bookAuthor = resultSet.getString("AUTHOR_NAME");
				int numCopies = resultSet.getInt("NUM_COPIES");

				bookList.add(new Book(id, bookName, bookAuthor, numCopies));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bookList;
		
	}

	@Override
	public Book searchBook(int id) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		Book book = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wiley", "root", "your_password");

			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE BOOK_ID = ?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int bid = resultSet.getInt("BOOK_ID");
				String bookName = resultSet.getString("BOOK_NAME");
				String bookAuthor = resultSet.getString("AUTHOR_NAME");
				int numCopies = resultSet.getInt("NUM_COPIES");

				book = new Book(bid, bookName, bookAuthor, numCopies);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}

	@Override
	public int addBook(Book book) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		int rows = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wiley", "root", "your_password");

			preparedStatement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?)");

			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setInt(4, book.getNumCopies());

			rows = preparedStatement.executeUpdate();

			return rows;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
		
	}

	@Override
	public int deleteBook(int id) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		int rows = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wiley", "root", "your_password");

			preparedStatement = connection.prepareStatement("DELETE FROM BOOKS WHERE BOOK_ID=?");

			preparedStatement.setInt(1, id);

			rows = preparedStatement.executeUpdate();

			return rows;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
}