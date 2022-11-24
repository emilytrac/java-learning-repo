package com.groupfour.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.groupfour.entity.Book;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		int bid = rs.getInt("BOOK_ID");
		String name = rs.getString("BOOK_NAME");
		String author = rs.getString("AUTHOR_NAME");
		int copies = rs.getInt("NUM_COPIES");

		Book book = new Book(bid, name, author, copies);
		return book;
	}

}
