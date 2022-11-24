/**
 *
 * @author kharileigh
 * 
 */

package com.teamsix.book.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// TESTING PROJECT
@Configuration
	@ComponentScan(basePackages = "com.teamsix")
	public class BookConfiguration {
	
	@Bean(name="MySqlDataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.springframework.jdbc.datasource.DriverManagerDataSource");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/wileydi001");
		ds.setUsername("root");
		ds.setPassword("cec1l3r0y!");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(getDataSource());
	}
}
