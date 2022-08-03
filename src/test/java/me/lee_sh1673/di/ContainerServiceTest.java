package me.lee_sh1673.di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ContainerServiceTest {

	@Test
	public void getObject_BookRepository_Correctly() {
		BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
		Assertions.assertNotNull(bookRepository);
	}

	@Test
	public void getObject_BookService_Correctly() {
		DefaultBookService bookService = ContainerService.getObject(DefaultBookService.class);
		Assertions.assertNotNull(bookService);
		Assertions.assertNotNull(bookService.bookRepository);
	}
}
