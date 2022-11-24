/**
 *
 * @author kharileigh
 * <------ STEP 5 : MAKES CALLS TO DAO TO RETRIEVE & ADD DATA TO DATABASE ------>
 */

package com.teamsix.book.service;

import com.teamsix.book.entity.Book;

import java.util.Collection;


public interface BookService {
    
    // COLLECTION FOR ALL BOOKS
    Collection<Book> getAllBooks();
    
    // BOOK OBJECT TO SEARCH BY ID
    Book searchBookById(int id);
    
    // BOOLEAN TO CHECK IF BOOK EXISTS BEFORE ADDING NEW BOOK OBJECT
    boolean addBook(Book book);
    
    boolean incrementNoOfCopies(int id, int increment);
}
