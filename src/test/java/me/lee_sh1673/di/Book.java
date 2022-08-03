package me.lee_sh1673.di;

public class Book {

	private String title;

	public Book() {
		this("No Titled");
	}

	public Book(String title) {
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
