package model;

public class Textbook {
	private String title;
	private String author;
	private String publisher;
	private String isbn;
	private double price;

	public Textbook(String title, String author, String publisher, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Textbook(Textbook t) {
		super();
		this.title = t.title;
		this.author = t.author;
		this.publisher = t.publisher;
		this.isbn = t.isbn;
		this.price = t.price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Textbook [title=" + title + ", author=" + author + ", publisher=" + publisher + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

}
