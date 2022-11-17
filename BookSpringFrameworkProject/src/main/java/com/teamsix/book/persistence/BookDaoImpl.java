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




public class BookDaoImpl implements BookDao {

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
        
        Connection connection = null;
        
        PreparedStatement preparedStatement;
        
        
        // USED TO KEEP TRACK IF NEW ROW(OBJECT) HAS BEEN ADDED TO DATABASE
        int rows = 0;
        
        
        // TRY-CATCH BLOCK 
        // setter methods - set each question to respective field
        // getter methods - get book properties entered by user in presentation layer
        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "cec1l3r0y!");
          
      
            // SEND DDL QUERY
            preparedStatement = connection.prepareStatement("INSERT INTO BOOK VALUES(?,?,?,?)");
            
            preparedStatement.setInt(1, book.getBookId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getAuthorName());
            preparedStatement.setInt(4, book.getNoOfCopies());
            
            
            // EXECUTES DDL QUERY
            rows = preparedStatement.executeUpdate();
            
            return rows;
            
        
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
        
        return rows;
    }
    
    
}
