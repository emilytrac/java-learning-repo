package com.groupfour.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.groupfour.persistence.BookDaoImpl;
import com.groupfour.presentation.BookPresentation;
import com.groupfour.presentation.BookPresentationImpl;
import com.groupfour.service.BookServiceImpl;

@Configuration
public class BookConfiguration {

	@Bean(name="dao")
	public BookDaoImpl getPersistence() {
		return new BookDaoImpl();
	}
	
	@Bean(name="service")
	public BookServiceImpl getService() {
		return new BookServiceImpl(getPersistence());
	}
	
	@Bean(name="presentation")
	public BookPresentation getBookPresentation() {
		BookPresentationImpl presentation = new BookPresentationImpl();
		presentation.setBookPresentationImpl(getService());
		return presentation;
	}
}
