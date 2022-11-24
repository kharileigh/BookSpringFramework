/**
 *
 * @author kharileigh
 * <----- STEP 7 : OVERRIDE METHODS IN PRESENTATION INTERFACE ------>
 */

package com.teamsix.book.presentation;

import com.teamsix.book.entity.Book;
import com.teamsix.book.service.BookService;


import java.util.Collection;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bkPresentation")
public class BookPresentationImpl implements BookPresentation {
    
    //Presentation will pass the request to service for processing and gives response to client
    private BookService bookService;
    
    // SETTER METHOD -- USED BY CONFIGURATION FILE 
    @Autowired
    @Qualifier("service")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    

    @Override
    public void showMenu() {
            System.out.println("===========================");
            System.out.println("Book Management System");
            System.out.println("1. List All Books");
            System.out.println("2. Search Book By ID");
            System.out.println("3. Add New Book");
            System.out.println("4. Exit");
            System.out.println("============================");
            
    }
    
    @Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1:
			Collection<Book> books=bookService.getAllBooks();
			for(Book book:books) {
				System.out.println(book);
			}
			break;
		case 2:
			System.out.println("Enter Book ID : ");
			int id=scanner.nextInt();
			Book book=bookService.searchBookById(id);
			if(book!=null)
				System.out.println(book);
			else
				System.out.println("Book with id "+id+" does not exist");
			break;
                case 3:
			Book newBook = new Book();
			
			System.out.println("Enter Book id : ");
			newBook.setBookId(scanner.nextInt());
			System.out.println("Enter Book Name : ");
			newBook.setBookName(scanner.next());
                        System.out.println("Enter Author Name : ");
			newBook.setAuthorName(scanner.next());
                        System.out.println("Enter Number of Copies : ");
			newBook.setNoOfCopies(scanner.nextInt());
			
			if(bookService.addBook(newBook))
				System.out.println("Book Record Added");
			else
				System.out.println("Book with id "+newBook.getBookId()+" already exist, so cannot add it as a new book!");
			
			break;			
		case 8:
			System.out.println("Thanks for using Book Management System");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		}

	}

}

