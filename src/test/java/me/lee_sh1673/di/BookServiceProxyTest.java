package me.lee_sh1673.di;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BookServiceProxyTest {

	BookService bookService = (BookService)Proxy.newProxyInstance(
		BookService.class.getClassLoader(),
		new Class[] {BookService.class},
		new BookServiceInvocationHandler(new DefaultBookService())
	);

	private static class BookServiceInvocationHandler implements InvocationHandler {

		private final BookService bookService;

		public BookServiceInvocationHandler(BookService bookService) {
			this.bookService = bookService;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			long start = System.currentTimeMillis();
			method.invoke(bookService, args);
			System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
			return null;
		}
	}

	@Test
	public void should_Get_BookService_Correctly() {
		Book book = new Book();
		book.setTitle("Algorithm 4/e");
		bookService.rent(book);
	}
}