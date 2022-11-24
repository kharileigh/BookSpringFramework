/**
 *
 * @author kharileigh
 * <------ STEP 10 : CREATES DAO OBJECT TO TELL GET RETRIEVE/ADD DATA TO DATABASE ------>
 */
package com.teamsix.book.service;

import com.teamsix.book.entity.Book;
import com.teamsix.book.persistence.BookDao;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class BookServiceImpl implements BookService {
    
    private BookDao bookDao;
    
    // ARGS CONSTRUCTOR USING DAO AS ARGUMENT
    public BookServiceImpl(@Autowired BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookDao.getAllRecords();
    }

    @Override
    public Book searchBookById(int id) {
        return bookDao.searchRecord(id);
    }

    @Override
    public boolean addBook(Book book) {
        
        if (bookDao.insertRecord(book) > 0) {
            
            return true;
            
        } else {
            
            return false;
        }
    }

    @Override
    public boolean incrementNoOfCopies(int id, int increment) {
        
        if(bookDao.updateNoOfCopies(id, increment) > 0) {
            
            return true;
            
        } else {
            
            return false;
        }
    }
    
    
}
