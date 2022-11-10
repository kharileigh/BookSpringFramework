/**
 *
 * @author kharileigh
 * <------ STEP 2 : BLUEPRINT OF DATABASE (Book List) ----->
 * <------ STEP 3 : MIMIC DATABASE - map of Book object & put into Book List ----->
 */

package com.teamsix.book.database;

import com.teamsix.book.entity.Book;
import java.util.LinkedHashMap;
import java.util.Map;


public class BookDatabase {
    
    static private Map<Integer, Book> bookList = new LinkedHashMap<Integer, Book>();
    
    static {
		bookList.put(101, new Book(101, "AAAA", "James", 1000));
		bookList.put(102, new Book(102, "BBBB", "Anna", 1500));
		bookList.put(103, new Book(103, "CCCC", "Khari", 3000));
		bookList.put(104, new Book(104, "DDDD", "Lidija", 2000));
		bookList.put(105, new Book(106, "EEEE", "Leah", 6000));
    }

    public static Map<Integer, Book> getBookList() {
            return bookList;
    }
    
}
