package com.emily.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.emily.entity.Book;

@Component("dao")
public class BookDaoImpl implements BookDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Collection<Book> getAllBooks() {
		
		String query = "SELECT * FROM BOOKS";
		List<Book> books = jdbcTemplate.query(query, new BookRowMapper());
		return books;
		
	}

	@Override
	public Book searchBook(int id) {
		
		Book book = null;
		
		try {
			String query = "SELECT * FROM BOOKS WHERE BOOK_ID=?";
			book = jdbcTemplate.queryForObject(query, new BookRowMapper(), id);
		} catch (EmptyResultDataAccessException ex) {
				return null;
		}
		return book;
	}

	@Override
	public int addBook(Book book) {
		
		try {
			String query = "INSERT INTO BOOKS VALUES(?,?,?,?)";
			int rows = jdbcTemplate.update(query, book.getBookId(), book.getBookName(),
					book.getAuthorName(), book.getNumCopies());

			return rows;
		} catch (DuplicateKeyException ex) {
			return 0;
		}
		
	}

	@Override
	public int deleteBook(int id) {
		
		String query = "DELETE FROM BOOKS WHERE BOOK_ID=?";
		int rows = jdbcTemplate.update(query, id);

		return rows;
	}

	@Override
	public int updateBook(int id, int increment) {
		
		String query = "UPDATE BOOKS SET NUM_COPIES=NUM_COPIES+? WHERE BOOK_ID=?";
		int rows = jdbcTemplate.update(query, increment, id);

		return rows;
	}
}
