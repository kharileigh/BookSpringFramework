/**
 *
 * @author lidija
 * <------- STEP 4 : CREATE DATA ACCESS OBJECT ----->
 * 
 */

package com.teamsix.book.persistence;

import com.teamsix.book.entity.Book;
import java.util.Collection;


public interface BookDao {
    
    Collection<Book> getAllRecords();
    Book searchRecord(int id);
    int insertRecord(Book book);
}
