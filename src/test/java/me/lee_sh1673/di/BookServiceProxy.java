package me.lee_sh1673.di;

public class BookServiceProxy implements BookService {

	private BookService bookService;

	public BookServiceProxy(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void rent(Book book) {

		if (bookService == null) {
			this.bookService = new DefaultBookService();
		}
		long start = System.currentTimeMillis();
		bookService.rent(book);
		System.out.println("Time: " + (System.currentTimeMillis() - start));
	}
}
