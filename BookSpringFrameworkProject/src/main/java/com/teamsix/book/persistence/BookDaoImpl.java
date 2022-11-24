/**
 *
 * @author kharileigh
 * <------- STEP 9 : OVERRIDE FUNCTIONS IN DAO ------->
 */

package com.teamsix.book.persistence;

import com.teamsix.book.entity.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository("dao")
public class BookDaoImpl implements BookDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // -------- DQL QUERY --------- //
    @Override
    public Collection<Book> getAllRecords() {
        
        Connection connection = null;
        
        PreparedStatement preparedStatement;
        
        
        // STORES EMPLOYED PULLED FROM DATABASE INTO A COLLECTION
        Collection <Book> bookList = new ArrayList<Book>();
        
        
        // TRY-CATCH BLOCK TO FECTH DATA FROM DATABASE USING GETTER METHODS
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "cec1l3r0y!");
            
            
            // SEND DQL QUERY
            preparedStatement = connection.prepareStatement("SELECT * FROM BOOK");
           
            
            // EXECUTE DQL QUERY
            ResultSet resultSet = preparedStatement.executeQuery();
           
            
            // WHILE LOOP TO CONTINUE GETTING DATA AS LONG AS THERE ARE ROWS LEFT
            while (resultSet.next()) {
            
                int id = resultSet.getInt("BOOKID");
                String name = resultSet.getString("NAME");
                String authorName = resultSet.getString("AUTHOR");
                int noOfCopies = resultSet.getInt("COPIES");
                
                // gets all books from database, puts them in collection
                bookList.add(new Book(id, name, authorName, noOfCopies));
            
            }
        
        
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        
        } catch (SQLException e) {
        
            e.printStackTrace();
          
            
        // CLOSES CONNECTION TO DATABASE
        } finally {
        
            try {
            
                connection.close();
            
            } catch (SQLException e) {
            
                e.printStackTrace();
            }
        
        }
        
        
        // RETURNS COLLECTION OF EMPLOYEES PULLED FROM DATABASE
        return bookList;
    }

    
    
    
     // -------- DQL QUERY --------- //
    @Override
    public Book searchRecord(int id) {
        
        Connection connection = null;
        
        PreparedStatement preparedStatement;
        
        // BOOK OBJECT TO STORE DATA FETCHED FROM DATABASE
        Book book = null;
        
        
        // TRY-CATCH BLOCK TO FECTH DATA FROM DATABASE USING GETTER METHODS
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "cec1l3r0y!");
          
      
            // SEND DQL QUERY
            preparedStatement = connection.prepareStatement("SELECT * FROM BOOK WHERE BOOKID = ?");
            preparedStatement.setInt(1, id);
            
            
            // EXECUTES DQL QUERY
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            // IF BLOCK - AS LONG AS THERE ARE ROWS, CONTINUE GETTING DATA
            if (resultSet.next()) {
            
                int bId = resultSet.getInt("BOOKID");
                String name = resultSet.getString("NAME");
                String authorName = resultSet.getString("AUTHOR");
                int noOfCopies = resultSet.getInt("COPIES");
            
                
                // NEW BOOK OBJECT STORING ALL DATA FETCHED FROM DATABASE
                book = new Book(bId, name, authorName, noOfCopies);
            }
        
         
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        
        } catch (SQLException e) {
        
            e.printStackTrace();
          
            
        // CLOSES CONNECTION TO DATABASE
        } finally {
        
            try {
            
                connection.close();
            
            } catch (SQLException e) {
            
                e.printStackTrace();
            }
        
        }
        
        return book;
        

    }

    
     // -------- DDL QUERY --------- //
    @Override
    public int insertRecord(Book book) {
    
        try {
            
            String query = "INSERT INTO BOOK VALUES(?,?,?,?)";
            
            int rows = jdbcTemplate.update(query, book.getBookId(), book.getBookName(), book.getAuthorName(), book.getNoOfCopies());
            
            return rows;
        
        } catch (DuplicateKeyException ex) {
            return 0;
        }
    }
    
    @Override
    public int updateNoOfCopies(int id, int increment) {
    
        String query = "UPDATE BOOK SET NOOFCOPIES = NOOFCOPIES+? WHERE BOOKID=?";
        
        int rows = jdbcTemplate.update(query, increment, id);
        
        return rows;
    }
    
}
