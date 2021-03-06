package book;

import org.apache.commons.lang3.StringUtils;

// vo 생성
public class Book {
	// 도서번호, 도서명, 출판사, 저자, 도서등록일 
	private int no;
	private String name;
	private String publisher;
	private String author;
	private String regDate;
	public Book() {}

	public Book(int no, String name, String publisher, String author, String regDate) {
		super();
		this.no = no;
		this.name = name;
		this.publisher = publisher;
		this.author = author;
		this.regDate = regDate;
	}
	public Book(Book book) {
		this.no = book.no;
		this.name = book.name;
		this.publisher = book.publisher;
		this.author = book.author;
		this.regDate = book.regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
