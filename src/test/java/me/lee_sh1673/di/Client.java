package me.lee_sh1673.di;

public class Client {
	public static void main(String[] args) {
		final Book book = new Book();
		BookService bookService = new BookServiceProxy(new DefaultBookService());

		book.setTitle("Discrete mathematics and it's application.");
		bookService.rent(book);
	}
}
