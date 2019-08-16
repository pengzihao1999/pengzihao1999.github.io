package test.book.domain;

public class Book {
	private String bookID;
	private String bookname;
    private String author;
    private String  pulishedlocation;
    private int price;
    public String getBookID() {
		return bookID;
	}
	public void setBookID(String string) {
		this.bookID = string;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPulishedlocation() {
		return pulishedlocation;
	}
	public void setPulishedlocation(String pulishedlocation) {
		this.pulishedlocation = pulishedlocation;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookname=" + bookname
				+ ", author=" + author + ", pulishedlocation="
				+ pulishedlocation + ", price=" + price + "]";
	}  
}