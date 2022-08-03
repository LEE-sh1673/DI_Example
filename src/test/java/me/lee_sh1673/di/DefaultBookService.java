package me.lee_sh1673.di;

public class DefaultBookService implements BookService {

	@Inject
	BookRepository bookRepository;

	@Override
	public void rent(Book book) {
		System.out.println("rent: " + book.getTitle());
	}
}
