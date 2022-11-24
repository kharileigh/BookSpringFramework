/**
 *
 * @author kharileigh
 */
package com.teamsix.book.persistence;

import com.teamsix.book.entity.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
       
        int id = rs.getInt("BOOKID");
        String name = rs.getString("NAME");
        String authorName = rs.getString("AUTHOR");
        int noOfCopies = rs.getInt("COPIES");
        
        Book book = new Book(id, name, authorName, noOfCopies);
        return book;
    }
    
    
}
