package com.groupfour.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.groupfour")

public class BookConfiguration {

	@Bean(name="MySqlDataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/YOUR_DATABASE");
		ds.setUsername("root");
		ds.setPassword("YOUR_PASSWORD");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(getDataSource());
	}
}
