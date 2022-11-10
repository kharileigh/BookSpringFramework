/**
 *
 * @author kharileigh
 * <------ STEP 10 : CREATES DAO OBJECT TO TELL GET RETRIEVE/ADD DATA TO DATABASE ------>
 */
package com.teamsix.book.service;

import com.teamsix.book.entity.Book;
import com.teamsix.book.persistence.BookDao;
import java.util.Collection;


public class BookServiceImpl implements BookService {
    
    private BookDao bookDao;
    
    // ARGS CONSTRUCTOR USING DAO AS ARGUMENT
    public BookServiceImpl(BookDao bookDao) {
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
        // create new object and use Dao to search 
        Book newBook = bookDao.searchRecord(book.getBookId());
        if(newBook != null) {
            return false;
        } else {
            bookDao.insertRecord(book);
            return true;
        }
    }
    
    
}
