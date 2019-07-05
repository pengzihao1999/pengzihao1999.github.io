package BookDomain;

public class Book {
	public String BookID;
	public String BookName;
	public String BookPublish;
	public String BookAuthor;
	public String BookNumber;
	@Override
	public String toString() {
		return "Book [BookID=" + BookID + ", BookName=" + BookName
				+ ", BookPublish=" + BookPublish + ", BookAuthor=" + BookAuthor
				+ ", BookNumber=" + BookNumber + "]";
	}
	public String getBookID() {
		return BookID;
	}
	public void setBookID(String bookID) {
		BookID = bookID;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookPublish() {
		return BookPublish;
	}
	public void setBookPublish(String bookPublish) {
		BookPublish = bookPublish;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public String getBookNumber() {
		return BookNumber;
	}
	public void setBookNumber(String bookNumber) {
		BookNumber = bookNumber;
	}
}
