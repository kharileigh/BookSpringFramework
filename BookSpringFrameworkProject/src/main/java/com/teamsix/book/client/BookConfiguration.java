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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// TESTING PROJECT
@Configuration
	@ComponentScan(basePackages = "com.sujata")
	public class BookConfiguration {
	
	@Bean(name="MySqlDataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.springframework.jdbc.datasource.DriverManagerDataSource");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/wileydi001");
		ds.setUsername("root");
		ds.setPassword("rootroot");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(getDataSource());
	}
}
