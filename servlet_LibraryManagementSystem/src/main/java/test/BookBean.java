package test;

import java.io.*;

@SuppressWarnings("serial")
public class BookBean implements Serializable{
	
	private String BookCode,BookName,AuthorName;
	private float price;
	private int quantity;
	
	public BookBean()
	{
		
	}

	public String getBookCode() {
		return BookCode;
	}

	public void setBookCode(String bookCode) {
		BookCode = bookCode;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
