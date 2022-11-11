/**
 *
 * @author kharileigh
 * 
 */

package com.teamsix.book.client;

import com.teamsix.book.persistence.BookDaoImpl;
import com.teamsix.book.presentation.BookPresentationImpl;
import com.teamsix.book.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {
    
    @Bean(name="dao")
    public BookDaoImpl getPersistence() {
            return new BookDaoImpl();
    }

    @Bean(name="service")
    public BookServiceImpl getBookService() {
            //Constructor Injection
            return new BookServiceImpl(getPersistence());
    }

    @Bean(name="bkPresentation")
    public BookPresentationImpl getBookPresentation() {
            //Setter Injection
            BookPresentationImpl presentation=new BookPresentationImpl();
            presentation.setBookService(getBookService());
            return presentation;
    }
}
